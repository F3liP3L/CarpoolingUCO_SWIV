package co.edu.uco.application.dto.requestroute;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class RouteIdDTO {
    private UUID id;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public static RouteIdDTO build() {
        return new RouteIdDTO();
    }
}
