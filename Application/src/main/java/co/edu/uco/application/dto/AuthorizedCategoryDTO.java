package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilText;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class AuthorizedCategoryDTO {
    private UUID id;
    private String category;
    public AuthorizedCategoryDTO(UUID id, String category) {
        setId(id);
        setCategory(category);
    }

    public AuthorizedCategoryDTO() {
        setId(getUtilUUID().DEFAULT_UUID);
        setCategory(UtilText.EMPTY);
    }

    public AuthorizedCategoryDTO(UUID uuid) {
        setId(uuid);
        setCategory(UtilText.EMPTY);
    }

    public static AuthorizedCategoryDTO createNewAuthorizedCategory() {
        return new AuthorizedCategoryDTO();
    }

    public static AuthorizedCategoryDTO create(UUID id) {
        return new AuthorizedCategoryDTO(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = getUtilText().trim(category);
    }

}
