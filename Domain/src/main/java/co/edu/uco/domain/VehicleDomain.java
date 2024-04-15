package co.edu.uco.domain;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class VehicleDomain {
    private UUID id;
    private String plate;
    private int capacity;
    private DriverDomain owner;

    public VehicleDomain(UUID id, String plate, int capacity, DriverDomain owner) {
        setId(id);
        setPlate(plate);
        setCapacity(capacity);
        setOwner(owner);
    }

    public VehicleDomain() {
        super();
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setPlate(EMPTY);
        setCapacity(ZERO);
        setOwner(DriverDomain.createNewDriver());
    }

    private VehicleDomain(UUID id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public static VehicleDomain createNewVehicle() {
        return new VehicleDomain();
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

    public void setOwner(DriverDomain owner) {
        this.owner = UtilObject.getUtilObject().getDefaultIsNull(owner, DriverDomain.createNewDriver());
    }

    public VehicleDomain buildPatch() {
        return new VehicleDomain(id, capacity);
    }
}
