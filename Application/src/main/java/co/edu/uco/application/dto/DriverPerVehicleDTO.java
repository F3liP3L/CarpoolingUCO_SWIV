package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

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
        setId(UtilUUID.getNewUUID());
        setVehicle(VehicleDTO.create());
        setStatus(StatusDTO.createNewStatus());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = UtilObject.getUtilObject().getDefaultIsNull(vehicle,VehicleDTO.create());
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = UtilObject.getUtilObject().getDefaultIsNull(status,StatusDTO.createNewStatus());
    }
    public static DriverPerVehicleDTO create() {
        return new DriverPerVehicleDTO();
    }

    public static DriverPerVehicleDTO create(UUID id) {
        DriverDTO driver = new DriverDTO(id);
        DriverPerVehicleDTO driverPerVehicleDTO = DriverPerVehicleDTO.create();
        return driverPerVehicleDTO;
    }
}
