package co.edu.uco.util.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr353.JSR353Module;

import javax.json.JsonPatch;
import javax.json.JsonStructure;
import javax.json.JsonValue;

public final class UtilPatchMapper {
    private static final UtilPatchMapper INSTANCE = new UtilPatchMapper();
    public UtilPatchMapper() {}

    public static UtilPatchMapper getUtilObjectMapper() { return INSTANCE; }
    private ObjectMapper mapper = new ObjectMapper();

    public ObjectMapper objectMapperJsonPath() {
        mapper.registerModule(new JSR353Module());
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .findAndRegisterModules();
        return mapper;

    }

    public <T> T patch(JsonPatch patch, T targetBean, Class<T> beanClass) {
        // Convert the Java bean to a JSON document
        JsonStructure target = objectMapperJsonPath().convertValue(targetBean, JsonStructure.class);

        // Apply the JSON Patch to the JSON document
        JsonValue patched = patch.apply(target);

        // Convert the JSON document to a Java bean and return it
        return objectMapperJsonPath().convertValue(patched, beanClass);
    }
}
