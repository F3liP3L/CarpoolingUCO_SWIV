package co.edu.uco.entity.model;

import java.io.Serial;
import java.io.Serializable;

public class JwtRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -6949694082753451838L;

    private String companyEmail;
    private String password;

    public JwtRequest() {}

    public JwtRequest(String companyEmail, String password) {
        this.setCompanyEmail(companyEmail);
        this.setPassword(password);
    }

    public String getCompanyEmail() {
        return this.companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
