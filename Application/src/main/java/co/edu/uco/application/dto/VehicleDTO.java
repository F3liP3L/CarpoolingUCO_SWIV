package co.edu.uco.application.dto;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class VehicleDTO {
    private UUID id;
    private String plate;
    private int capacity;
    private DriverDTO owner;

    public VehicleDTO(UUID id, String plate, int capacity, DriverDTO owner) {
        setId(id);
        setPlate(plate);
        setCapacity(capacity);
        setOwner(owner);
    }

    public VehicleDTO() {
        setId(getUtilUUID().getDefaultUUID(id));
        setPlate(EMPTY);
        setCapacity(ZERO);
        setOwner(DriverDTO.create());
    }

    public VehicleDTO(int capacity) {
        this.id = getId();
        this.capacity = capacity;
        this.plate = getPlate();
        this.owner = getOwner();
    }

    public static VehicleDTO create() {
        return new VehicleDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = getUtilText().trim(plate).toUpperCase();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = (int) getUtilNumeric().getDefault(capacity);
    }

    public DriverDTO getOwner() {
        return owner;
    }

    public void setOwner(DriverDTO owner) {
        this.owner = getUtilObject().getDefaultIsNull(owner,DriverDTO.create());
    }

    public VehicleDTO createPatch() {
        return new VehicleDTO(capacity);
    }
}
