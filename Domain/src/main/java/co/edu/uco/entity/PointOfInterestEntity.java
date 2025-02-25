package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class PointOfInterestEntity {
    private UUID id;
    private String name;

    public PointOfInterestEntity(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public PointOfInterestEntity() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = UtilText.trim(name);
    }
    public static PointOfInterestEntity build() {
        return new PointOfInterestEntity();
    }

}
