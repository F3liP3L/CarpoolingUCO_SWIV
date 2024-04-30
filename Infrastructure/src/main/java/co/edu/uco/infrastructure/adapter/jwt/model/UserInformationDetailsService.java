package co.edu.uco.infrastructure.adapter.jwt.model;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInformationDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomerEntity> response = repository.findByCompanyEmail(username);
        if (response.isEmpty()) {
            throw new UsernameNotFoundException("User not found with the email provided");
        }
        CustomerEntity customer = response.get();
        return new UserInformationDetails(customer);
    }
}
