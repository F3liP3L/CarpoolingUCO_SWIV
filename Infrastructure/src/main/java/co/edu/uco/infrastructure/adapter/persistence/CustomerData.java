package co.edu.uco.infrastructure.adapter.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "customer")
public class CustomerData {
    @Id
    private UUID id;
    @Column(name = "dni")
    private String dni;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "first_surname")
    private String firstSurname;
    @Column(name = "second_surname")
    private String secondSurname;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String companyEmail;
    @Column(name = "phone")
    private String phone;
    @Column(name = "rol")
    private int rol;
}
