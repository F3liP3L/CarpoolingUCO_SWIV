package co.edu.uco.infrastructure.controller;

import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.port.output.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juan Felipe Cardona;
 * Email: felipe7u7432@gmail.com
 * @version id: <b>CarpoolingUCO_SWIV/b> 13/4/2024, 21:55
 **/
@RestController
@RequestMapping("api/v1/carpooling-uco/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    public CustomerEntity getCustomer() {
        return customerRepository.findById(null).get();
    }



}
