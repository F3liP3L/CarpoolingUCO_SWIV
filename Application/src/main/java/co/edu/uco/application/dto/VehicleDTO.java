package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getDefault;
import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.trim;
import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

public class VehicleDTO {
    private UUID id;
    private String plate;
    private String name;
    private int capacity;
    private DriverDTO owner;

    public VehicleDTO(UUID id, String plate, String name, int capacity, DriverDTO owner) {
        setId(id);
        setPlate(plate);
        setName(name);
        setCapacity(capacity);
        setOwner(owner);
    }

    public VehicleDTO() {
        setId(UtilUUID.getNewUUID());
        setPlate(EMPTY);
        setName(EMPTY);
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
        this.id = getDefaultUUID(id);
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = trim(plate).toUpperCase();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = (int) getDefault(capacity);
    }

    public DriverDTO getOwner() {
        return owner;
    }

    public void setOwner(DriverDTO owner) {
        this.owner = getDefaultIsNull(owner,DriverDTO.create());
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = trim(name); }

    public VehicleDTO createPatch() {
        return new VehicleDTO(capacity);
    }
}
