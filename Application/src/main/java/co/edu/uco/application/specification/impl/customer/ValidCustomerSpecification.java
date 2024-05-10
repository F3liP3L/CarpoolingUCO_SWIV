package co.edu.uco.application.specification.impl.customer;

import co.edu.uco.application.specification.CompositeSpecification;
import co.edu.uco.entity.CustomerEntity;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidCustomerSpecification extends CompositeSpecification<CustomerEntity> {
    @Autowired
    CustomerDniValidSpecification dniValidSpecification;
    @Autowired
    CustomerIdValidSpecification idValidSpecification;
    @Autowired
    CustomerEmailValidSpecification emailValidSpecification;
    @Autowired
    CustomerPhoneValidSpecification phoneValidSpecification;

    @Override
    public boolean isSatisfyBy(CustomerEntity object) {
        try {
            return dniValidSpecification.and(idValidSpecification)
                    .and(emailValidSpecification).and(phoneValidSpecification)
                    .isSatisfyBy(object);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        }
    }
}
