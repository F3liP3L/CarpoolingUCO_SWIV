package co.edu.uco.domain;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class DriverDomain {

    private UUID id;
    private String licenseNumber;
    private AuthorizedCategoryDomain authorizedCategory;
    private CustomerDomain customer;

    public DriverDomain(UUID id, String licenseNumber, AuthorizedCategoryDomain authorizedCategory,CustomerDomain customerDomain) {
        super();
        setId(id);
        setLicenseNumber(licenseNumber);
        setAuthorizedCategory(authorizedCategory);
        setCustomer(customerDomain);
    }

    public DriverDomain() {
        super();
        setId(UtilUUID.DEFAULT_UUID);
        setLicenseNumber(EMPTY);
        setAuthorizedCategory(AuthorizedCategoryDomain.createNewAuthorizedCategory());
        setCustomer(CustomerDomain.build());
    }

    public static DriverDomain createNewDriver() {
        return new DriverDomain();
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = UtilText.getUtilText().trim(licenseNumber);
    }

    public void setAuthorizedCategory(AuthorizedCategoryDomain authorizedCategory) {
        this.authorizedCategory = UtilObject.getUtilObject().getDefaultIsNull(authorizedCategory,
                AuthorizedCategoryDomain.createNewAuthorizedCategory());
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public AuthorizedCategoryDomain getAuthorizedCategory() {
        return authorizedCategory;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public CustomerDomain getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDomain customer) {
        this.customer = UtilObject.getUtilObject().getDefaultIsNull(customer, CustomerDomain.build());
    }
}
