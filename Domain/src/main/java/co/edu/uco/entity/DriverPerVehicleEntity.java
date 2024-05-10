package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class DriverPerVehicleEntity {

    private UUID id;
    private String name;
    private String plate;

    public UUID getId() {
        return id;
    }

    public DriverPerVehicleEntity() {
        super();
    }

    public DriverPerVehicleEntity(UUID id, String name, String plate) {
        setId(id);
        setName(name);
        setPlate(plate);
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

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = getUtilText().getDefault(plate);
    }

    public static DriverPerVehicleEntity build() {
        return new DriverPerVehicleEntity();
    }

    public static DriverPerVehicleEntity build(final UUID id, final String name, final String plate) {
        return new DriverPerVehicleEntity(id, name, plate);
    }
}
