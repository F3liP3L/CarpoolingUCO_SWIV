package co.edu.uco.application.dto.requestroute;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class RouteIdVO {
    private UUID id;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public static RouteIdVO build() {
        return new RouteIdVO();
    }
}
