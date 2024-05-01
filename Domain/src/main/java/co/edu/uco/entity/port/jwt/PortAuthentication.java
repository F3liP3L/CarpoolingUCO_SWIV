package co.edu.uco.entity.port.jwt;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.entity.model.JwtRequest;
import co.edu.uco.entity.model.JwtResponse;

public interface PortAuthentication {
    JwtResponse signIn(JwtRequest request);
    void customerSignUp(CustomerEntity request);
    void driverSignUp(DriverEntity request);
}
