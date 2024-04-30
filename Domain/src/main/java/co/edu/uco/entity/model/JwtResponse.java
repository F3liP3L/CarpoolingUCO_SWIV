package co.edu.uco.entity.model;

import lombok.Builder;

import java.io.Serial;
import java.io.Serializable;

@Builder
public class JwtResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -2310583951475293439L;

    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
