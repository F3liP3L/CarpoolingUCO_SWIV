package co.edu.uco.application.dto;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilText;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

public class CustomerDTO {
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

    public CustomerDTO(UUID id, String dni, String firstName, String secondName, String firstSurname,
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

    public CustomerDTO() {
        setId(getUtilUUID().getDefaultUUID(id));
        setDni(UtilText.EMPTY);
        setFirstName(UtilText.EMPTY);
        setSecondName(UtilText.EMPTY);
        setFirstSurname(UtilText.EMPTY);
        setSecondSurname(UtilText.EMPTY);
        setPassword(UtilText.EMPTY);
        setCompanyEmail(UtilText.EMPTY);
        setPhone(UtilText.EMPTY);
        setRol(UtilNumeric.ZERO);
    }

    private CustomerDTO(String password, String companyEmail, int rol) {
        this.password = password;
        this.companyEmail = companyEmail;
        this.rol = rol;
    }

    public static CustomerDTO create() {
        return new CustomerDTO();
    }
    public void setId(UUID id) {
        this.id = getUtilUUID().getDefaultUUID(id);
    }

    public void setDni(String dni) {
        this.dni = getUtilText().trim(dni);
    }

    public void setFirstName(String firstName) {
        this.firstName = getUtilText().trim(firstName);
    }

    public void setSecondName(String secondName) {
        this.secondName = getUtilText().trim(secondName);
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = getUtilText().trim(firstSurname);
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = getUtilText().trim(secondSurname);
    }

    public void setPhone(String phone) {
        this.phone = getUtilText().trim(phone);
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = getUtilText().trim(companyEmail);
    }

    public void setPassword(String password) {
        this.password = getUtilText().trim(password);
    }

    public void setRol(int rol) {
        this.rol = (int) getUtilNumeric().getDefault(rol);
    }

    public UUID getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getPhone() {
        return phone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }
    public String getPassword() {
        return password;
    }
    public int getRol() {
        return rol;
    }
}
