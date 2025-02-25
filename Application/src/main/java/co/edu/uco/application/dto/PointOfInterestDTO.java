package co.edu.uco.application.dto;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.trim;
import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

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
        this.id = getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = trim(name);
    }

    public static PointOfInterestDTO build() {
        return new PointOfInterestDTO();
    }

}
