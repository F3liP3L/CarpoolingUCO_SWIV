package co.edu.uco.application.dto.requestroute;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;

public class RouteIdDTO {
    private UUID id;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public static RouteIdDTO build() {
        return new RouteIdDTO();
    }
}
