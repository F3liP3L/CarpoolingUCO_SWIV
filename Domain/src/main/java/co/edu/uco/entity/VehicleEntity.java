package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

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
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setPlate(EMPTY);
        setCapacity(ZERO);
        setOwner(DriverEntity.createNewDriver());
    }

    private VehicleEntity(UUID id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public static VehicleEntity createNewVehicle() {
        return new VehicleEntity();
    }

    public void setId(UUID id) {
        this.id = id == null ? UtilUUID.getUtilUUID().getNewUUID() : UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public void setPlate(String plate) {
        this.plate = getUtilText().trim(plate).toUpperCase();
    }

    public void setCapacity(int capacity) {
        this.capacity = (int) UtilNumeric.getUtilNumeric().getDefault(capacity);
    }

    public void setOwner(DriverEntity owner) {
        this.owner = UtilObject.getUtilObject().getDefaultIsNull(owner, DriverEntity.createNewDriver());
    }

    public VehicleEntity buildPatch() {
        return new VehicleEntity(id, capacity);
    }
}
