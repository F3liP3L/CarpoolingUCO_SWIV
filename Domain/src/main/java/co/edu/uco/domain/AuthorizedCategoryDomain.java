package co.edu.uco.domain;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class AuthorizedCategoryDomain {
    private UUID id;
    private String category;
    public AuthorizedCategoryDomain(UUID id, String category) {
        setId(id);
        setCategory(category);
    }

    public AuthorizedCategoryDomain() {
        setId(UtilUUID.getUtilUUID().DEFAULT_UUID);
        setCategory(UtilText.EMPTY);
    }

    public static AuthorizedCategoryDomain createNewAuthorizedCategory() {
        return new AuthorizedCategoryDomain();
    }

    public void setId(UUID id) {
        this.id = id == null ? UtilUUID.getUtilUUID().getNewUUID() : UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public void setCategory(String category) {
        this.category = UtilText.getUtilText().trim(category);
    }
}
