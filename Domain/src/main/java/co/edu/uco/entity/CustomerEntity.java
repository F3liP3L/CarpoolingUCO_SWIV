package co.edu.uco.entity;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilNumeric.ZERO;
import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;

public class CustomerEntity {
    private UUID id;
    private String dni;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String password;
    private String companyEmail;
    private String phone;
    private int rol;

    public CustomerEntity(UUID id, String dni, String firstName, String secondName, String firstSurname,
                           String secondSurname, String password, String companyEmail, String phone, int rol) {
        setId(id);
        setDni(dni);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstSurname(firstSurname);
        setSecondSurname(secondSurname);
        setPassword(password);
        setCompanyEmail(companyEmail);
        setPhone(phone);
        setRol(rol);
    }

    public CustomerEntity() {
        setId(UtilUUID.getUtilUUID().getNewUUID());
        setFirstName(EMPTY);
        setPassword(EMPTY);
        setCompanyEmail(EMPTY);
        setDni(EMPTY);
        setSecondName(EMPTY);
        setFirstSurname(EMPTY);
        setSecondSurname(EMPTY);
        setPhone(EMPTY);
        setRol(ZERO);
    }

    public CustomerEntity(UUID id) {
        setId(id);
        setFirstName(EMPTY);
        setPassword(EMPTY);
        setCompanyEmail(EMPTY);
        setDni(EMPTY);
        setSecondName(EMPTY);
        setFirstSurname(EMPTY);
        setSecondSurname(EMPTY);
        setPhone(EMPTY);
        setRol(ZERO);
    }

    public static CustomerEntity create(UUID id) {
        return new CustomerEntity(id);
    }

    public UUID getId() { return id; }

    public void setId(UUID id) {
        this.id = UtilUUID.getUtilUUID().getDefaultUUID(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = getUtilText().getDefault(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getUtilText().getDefault(password);
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String mailEntity) {
        this.companyEmail = getUtilText().getDefault(mailEntity);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = getUtilText().getDefault(dni);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = getUtilText().trim(phone);
    }

    public static CustomerEntity build() {
        return new CustomerEntity();
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = getUtilText().getDefault(secondName);
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = getUtilText().getDefault(firstSurname);
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = getUtilText().getDefault(secondSurname);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = getUtilText().getDefault(phone);
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = (int) getUtilNumeric().getDefault(rol);
    }
}
