package co.edu.uco.infrastructure.adapter.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "route_selected")
public class RouteSelectedData {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerData customer;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteData route;
}
