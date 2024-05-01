package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class DriverPerVehicleEntity {

    private UUID id;
    private String name;
    private String nameVehicle;

    public UUID getId() {
        return id;
    }

    public DriverPerVehicleEntity() {
        super();
    }

    public DriverPerVehicleEntity(UUID id, String name, String nameVehicle) {
        setId(id);
        setName(name);
        setNameVehicle(nameVehicle);
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getUtilText().getDefault(name);
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = getUtilText().getDefault(nameVehicle);
    }

    public static final DriverPerVehicleEntity build() {
        return new DriverPerVehicleEntity();
    }

    public static final DriverPerVehicleEntity build(final UUID id, final String name, final String nameVehicle) {
        return new DriverPerVehicleEntity(id, name, nameVehicle);
    }
}
