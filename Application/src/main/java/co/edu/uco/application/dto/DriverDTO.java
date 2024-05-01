package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class DriverDTO {
    private UUID id;
    private String licenseNumber;
    private AuthorizedCategoryDTO authorizedCategory;
    private CustomerDTO customer;

    public DriverDTO(UUID id) {
        setId(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public DriverDTO(UUID id, String licenseNumber, AuthorizedCategoryDTO authorizedCategory, CustomerDTO customer) {
        super();
        setId(id);
        setLicenseNumber(licenseNumber);
        setAuthorizedCategory(authorizedCategory);
        setCustomer(customer);
    }

    public DriverDTO() {
        super();
        setId(getUtilUUID().getDefaultUUID(id));
        setLicenseNumber(EMPTY);
        setAuthorizedCategory(AuthorizedCategoryDTO.createNewAuthorizedCategory());
        setCustomer(CustomerDTO.create());
    }

    public static DriverDTO create() {
        return new DriverDTO();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = getUtilText().trim(licenseNumber);
    }

    public AuthorizedCategoryDTO getAuthorizedCategory() {
        return authorizedCategory;
    }

    public void setAuthorizedCategory(AuthorizedCategoryDTO authorizedCategory) {
        this.authorizedCategory = UtilObject.getUtilObject().getDefaultIsNull(authorizedCategory,
                AuthorizedCategoryDTO.createNewAuthorizedCategory());
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = UtilObject.getUtilObject().getDefaultIsNull(customer, CustomerDTO.create());
    }
}
