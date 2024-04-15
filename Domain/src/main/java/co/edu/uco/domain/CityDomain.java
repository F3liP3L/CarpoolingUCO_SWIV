package co.edu.uco.domain;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CityDomain {
    private UUID id;
    private String name;

    public CityDomain(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public CityDomain() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setName(EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = getUtilText().trim(name);}

    public static final CityDomain build(){
        return new CityDomain();
    }

    public static final CityDomain build(final UUID id, final String name){
        return new CityDomain(id,name);
    }

}
