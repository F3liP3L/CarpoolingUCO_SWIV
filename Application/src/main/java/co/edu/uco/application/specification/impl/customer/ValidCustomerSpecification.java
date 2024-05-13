package co.edu.uco.application.specification.impl.customer;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidCustomerSpecification extends CompositeSpecification<CustomerEntity> {
    @Autowired
    private CustomerDniValidSpecification dniValidSpecification;
    @Autowired
    private CustomerIdValidSpecification idValidSpecification;
    @Autowired
    private CustomerEmailValidSpecification emailValidSpecification;
    @Autowired
    private CustomerPhoneValidSpecification phoneValidSpecification;

    @Override
    public boolean isSatisfyBy(CustomerEntity object) {
        return dniValidSpecification.and(idValidSpecification)
                .and(emailValidSpecification).and(phoneValidSpecification)
                .isSatisfyBy(object);
    }
}
