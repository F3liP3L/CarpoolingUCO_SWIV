package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;

public class DriverEntity {

    private UUID id;
    private String licenseNumber;
    private AuthorizedCategoryEntity authorizedCategory;
    private CustomerEntity customer;

    public DriverEntity(UUID id, String licenseNumber, AuthorizedCategoryEntity authorizedCategory, CustomerEntity customerEntity) {
        super();
        setId(id);
        setLicenseNumber(licenseNumber);
        setAuthorizedCategory(authorizedCategory);
        setCustomer(customerEntity);
    }

    public DriverEntity() {
        super();
        setId(UtilUUID.getNewUUID());
        setLicenseNumber(EMPTY);
        setAuthorizedCategory(AuthorizedCategoryEntity.create());
        setCustomer(CustomerEntity.build());
    }

    public static DriverEntity createNewDriver() {
        return new DriverEntity();
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = UtilText.trim(licenseNumber);
    }

    public void setAuthorizedCategory(AuthorizedCategoryEntity authorizedCategory) {
        this.authorizedCategory = UtilObject.getDefaultIsNull(authorizedCategory,
                AuthorizedCategoryEntity.create());
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public AuthorizedCategoryEntity getAuthorizedCategory() {
        return authorizedCategory;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = UtilObject.getDefaultIsNull(customer, CustomerEntity.build());
    }
}
