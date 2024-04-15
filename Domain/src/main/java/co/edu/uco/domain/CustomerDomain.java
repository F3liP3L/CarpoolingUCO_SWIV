package co.edu.uco.domain;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilText;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilNumeric.getUtilNumeric;
import static co.edu.uco.crosscutting.util.UtilText.getUtilText;
import static co.edu.uco.crosscutting.util.UtilUUID.getUtilUUID;

/**
 * @author Juan Felipe Cardona;
 * Email: felipe7u7432@gmail.com
 * @version id: <b>CarpoolingUCO_SWIV/b> 13/4/2024, 18:41
 **/
public class CustomerDomain {
    private UUID id;
    private String dni;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String password;
    private String companyEmail;
    private int phone;
    private int rol;

    public CustomerDomain(UUID id, String dni, String firstName, String secondName, String firstSurname,
                          String secondSurname, String password, String companyEmail, int phone, int rol) {
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

    public CustomerDomain() {
        setId(getUtilUUID().getDefaultUUID(id));
        setDni(UtilText.EMPTY);
        setFirstName(UtilText.EMPTY);
        setSecondName(UtilText.EMPTY);
        setFirstSurname(UtilText.EMPTY);
        setSecondSurname(UtilText.EMPTY);
        setPassword(UtilText.EMPTY);
        setCompanyEmail(UtilText.EMPTY);
        setPhone(UtilNumeric.ZERO);
        setRol(UtilNumeric.ZERO);
    }

    private CustomerDomain(String password, String companyEmail, int rol) {
        this.password = password;
        this.companyEmail = companyEmail;
        this.rol = rol;
    }

    public static CustomerDomain create() {
        return new CustomerDomain();
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

    public void setPhone(int phone) {
        this.phone = (int) getUtilNumeric().getDefault(phone);
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

    public int getPhone() {
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
