package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class VehicleEntity {
    private UUID id;
    private String name;
    private String plate;
    private int capacity;
    private DriverEntity owner;

    public VehicleEntity(UUID id, String name, String plate, int capacity, DriverEntity owner) {
        setId(id);
        setPlate(plate);
        setCapacity(capacity);
        setOwner(owner);
        setName(name);
    }

    public VehicleEntity() {
        super();
        setId(UtilUUID.getNewUUID());
        setPlate(EMPTY);
        setName(EMPTY);
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
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public void setPlate(String plate) {
        this.plate = UtilText.trim(plate).toUpperCase();
    }

    public void setCapacity(int capacity) {
        this.capacity = (int) UtilNumeric.getDefault(capacity);
    }

    public void setOwner(DriverEntity owner) {
        this.owner = UtilObject.getDefaultIsNull(owner, DriverEntity.createNewDriver());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = UtilText.trim(name);
    }

    public VehicleEntity buildPatch() {
        return new VehicleEntity(id, capacity);
    }
}
