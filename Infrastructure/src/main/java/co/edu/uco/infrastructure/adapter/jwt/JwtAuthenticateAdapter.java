package co.edu.uco.infrastructure.adapter.jwt;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.entity.model.JwtRequest;
import co.edu.uco.entity.model.JwtResponse;
import co.edu.uco.entity.port.jwt.PortAuthentication;
import co.edu.uco.infrastructure.adapter.jwt.model.UserInformationDetailsService;
import co.edu.uco.port.output.repository.CustomerRepository;
import co.edu.uco.port.output.repository.DriverRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticateAdapter  implements PortAuthentication {

    @Autowired
    private UserInformationDetailsService userInformationDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private JwtTokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public JwtResponse signIn(JwtRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCompanyEmail(), request.getPassword()));
        } catch (BadCredentialsException exception) {
            throw CarpoolingCustomException.buildUserException("The credentials entered are incorrect.");
        }
        final UserDetails userDetails = userInformationDetailsService
                .loadUserByUsername(request.getCompanyEmail());
        final String jwt = tokenService.generateToken(userDetails.getUsername());
        return new JwtResponse(jwt);
    }

    @Override
    public void customerSignUp(CustomerEntity request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        customerRepository.save(request);
    }

    @Override
    public void driverSignUp(DriverEntity request) {
        request.getCustomer().setPassword(passwordEncoder.encode(request.getCustomer().getPassword()));
        driverRepository.save(request);
    }
}
