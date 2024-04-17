package co.edu.uco.infrastructure.adapter.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
@Entity
@Table(name = "driver")
public class DriverEntity {
    @Id
    private UUID id;
    @Column(name = "license")
    private String licenseNumber;
    @ManyToOne
    @JoinColumn(name = "authorized_category")
    private AuthorizedCategoryData authorizedCategory;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerData customer;


}
