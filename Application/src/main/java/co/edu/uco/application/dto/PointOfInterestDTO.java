package co.edu.uco.application.dto;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class PointOfInterestDTO {
    private UUID id;
    private String name;
    public PointOfInterestDTO(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public PointOfInterestDTO() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public static PointOfInterestDTO build() {
        return new PointOfInterestDTO();
    }

}
