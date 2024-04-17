package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class AuthorizedCategoryEntity {
    private UUID id;
    private String category;
    public AuthorizedCategoryEntity(UUID id, String category) {
        setId(id);
        setCategory(category);
    }

    public AuthorizedCategoryEntity() {
        setId(UtilUUID.getUtilUUID().DEFAULT_UUID);
        setCategory(UtilText.EMPTY);
    }

    public static AuthorizedCategoryEntity createNewAuthorizedCategory() {
        return new AuthorizedCategoryEntity();
    }

    public void setId(UUID id) {
        this.id = id == null ? UtilUUID.getUtilUUID().getNewUUID() : UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public void setCategory(String category) {
        this.category = UtilText.getUtilText().trim(category);
    }
}
