package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class StatusEntity {
    private UUID id;
    private String status;

    public StatusEntity(UUID id, String status) {
        setId(id);
        setStatus(status);
    }

    public StatusEntity() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = UtilText.trim(status);}

    public static StatusEntity build() {
        return new StatusEntity();
    }

}
