package co.edu.uco.domain;

import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;

public class CustomerDomain {
    private UUID id;
    private String name;
    private String password;
    private String mailEntity;
    private String documentIdentity;

    public CustomerDomain(UUID id, String name, String password, String mailEntity, String documentIdentity) {
        setId(id);
        setName(name);
        setPassword(password);
        setMailEntity(mailEntity);
        setDocumentIdentity(documentIdentity);
    }

    public CustomerDomain() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setName(EMPTY);
        setPassword(EMPTY);
        setMailEntity(EMPTY);
        setDocumentIdentity(EMPTY);
    }

    public UUID getId() { return id; }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = getUtilText().getDefault(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getUtilText().getDefault(password);
    }

    public String getMailEntity() {
        return mailEntity;
    }

    public void setMailEntity(String mailEntity) {
        this.mailEntity = getUtilText().getDefault(mailEntity);
    }

    public String getDocumentIdentity() {
        return documentIdentity;
    }

    public void setDocumentIdentity(String documentIdentity) {
        this.documentIdentity = getUtilText().getDefault(documentIdentity);
    }

    public static CustomerDomain build() {
        return new CustomerDomain();
    }
}
