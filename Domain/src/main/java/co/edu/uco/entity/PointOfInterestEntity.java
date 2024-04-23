package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

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
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }
    public static PointOfInterestEntity build() {
        return new PointOfInterestEntity();
    }

}
