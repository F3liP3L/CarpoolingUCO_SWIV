package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class DriverPerVehicleEntity {

    private UUID id;
    private VehicleEntity vehicle;
    private String status;

    public UUID getId() {
        return id;
    }

    public DriverPerVehicleEntity() {
        super();
    }

    public DriverPerVehicleEntity(UUID id, VehicleEntity vehicle ,String status) {
        setId(id);
        setVehicle(vehicle);
        setStatus(status);
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public VehicleEntity getVehicle() { return vehicle; }

    public void setVehicle(VehicleEntity vehicle) {
        this.vehicle = getUtilObject().getDefaultIsNull(vehicle, VehicleEntity.build());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = getUtilObject().getDefaultIsNull(status,EMPTY);
    }

    public static DriverPerVehicleEntity build() {
        return new DriverPerVehicleEntity();
    }

    public static DriverPerVehicleEntity build(final UUID id) {
        return new DriverPerVehicleEntity(id, VehicleEntity.build(), EMPTY);
    }
}
