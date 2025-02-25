package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.trim;
import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

public class DriverPerVehicleDTO {
    private UUID id;
    private VehicleDTO vehicle;
    private String status;

    public DriverPerVehicleDTO(UUID id, VehicleDTO vehicle, String status) {
        setId(id);
        setVehicle(vehicle);
        setStatus(status);
    }

    public DriverPerVehicleDTO() {
        setId(UtilUUID.getNewUUID());
        setVehicle(VehicleDTO.create());
        setStatus(EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = getDefaultIsNull(vehicle,VehicleDTO.create());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = trim(status);
    }

    public static DriverPerVehicleDTO build() {
        return new DriverPerVehicleDTO();
    }
}
