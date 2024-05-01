package co.edu.uco.entity;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

/**
 * @author Juan Felipe Cardona;
 * Email: felipe7u7432@gmail.com
 * @version id: <b>CarpoolingUCO_SWIV/b> 16/4/2024, 23:30
 **/
public class RouteRequestDriverVehicleEntity {
    private UUID id;
    private String name;
    private String nameVehicle;
    public UUID getId() {
        return id;
    }
    public RouteRequestDriverVehicleEntity() {
        setId(getUtilUUID().getDefaultUUID(id));
        setName(EMPTY);
        setNameVehicle(EMPTY);
    }

    public RouteRequestDriverVehicleEntity(UUID id, String name, String nameVehicle) {
        setId(id);
        setName(name);
        setNameVehicle(nameVehicle);
    }

    public void setId(UUID id) { this.id = getUtilUUID().getDefaultUUID(id); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getUtilText().trim(name);
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = getUtilText().trim(nameVehicle);
    }

    public static RouteRequestDriverVehicleEntity build() {
        return new RouteRequestDriverVehicleEntity();
    }
}
