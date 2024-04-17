package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilObject;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class DriverPerVehicleDTO {
    private UUID id;
    private VehicleDTO vehicle;
    private StatusDTO status;

    public DriverPerVehicleDTO(UUID id, VehicleDTO vehicle, StatusDTO status) {
        setId(id);
        setVehicle(vehicle);
        setStatus(status);
    }

    public DriverPerVehicleDTO() {
        setId(getUtilUUID().getNewUUID());
        setVehicle(VehicleDTO.create());
        setStatus(StatusDTO.createNewStatus());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = getUtilObject().getDefaultIsNull(vehicle,VehicleDTO.create());
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = getUtilObject().getDefaultIsNull(status,StatusDTO.createNewStatus());
    }
    public static DriverPerVehicleDTO create() {
        return new DriverPerVehicleDTO();
    }
}
