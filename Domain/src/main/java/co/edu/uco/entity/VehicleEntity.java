package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class VehicleEntity {
    private UUID id;
    private String plate;
    private int capacity;
    private DriverEntity owner;

    public VehicleEntity(UUID id, String plate, int capacity, DriverEntity owner) {
        setId(id);
        setPlate(plate);
        setCapacity(capacity);
        setOwner(owner);
    }

    public VehicleEntity() {
        super();
        setId(getUtilUUID().getNewUUID());
        setPlate(EMPTY);
        setCapacity(ZERO);
        setOwner(DriverEntity.createNewDriver());
    }

    private VehicleEntity(UUID id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public UUID getId() { return id; }

    public String getPlate() {
        return plate;
    }

    public int getCapacity() {
        return capacity;
    }

    public DriverEntity getOwner() {
        return owner;
    }

    public static VehicleEntity build() {
        return new VehicleEntity();
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public void setPlate(String plate) {
        this.plate = getUtilText().trim(plate).toUpperCase();
    }

    public void setCapacity(int capacity) {
        this.capacity = (int) getUtilNumeric().getDefault(capacity);
    }

    public void setOwner(DriverEntity owner) {
        this.owner = getUtilObject().getDefaultIsNull(owner, DriverEntity.createNewDriver());
    }

    public VehicleEntity buildPatch() {
        return new VehicleEntity(id, capacity);
    }
}
