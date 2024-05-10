package co.edu.uco.application.dto;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class DriverPerVehicleDTO {
    private UUID id;
    private String name;
    private String plate;

    public DriverPerVehicleDTO() {
        setId(getUtilUUID().getNewUUID());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = getUtilText().trim(plate);
    }

    public static DriverPerVehicleDTO build() {
        return new DriverPerVehicleDTO();
    }
}
