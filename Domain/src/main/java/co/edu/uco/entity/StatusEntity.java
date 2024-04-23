package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

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
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = getUtilText().trim(status);}

    public static StatusEntity build() {
        return new StatusEntity();
    }

}
