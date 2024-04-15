package co.edu.uco.infrastructure.adapter.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "driver_per_vehicle")
public class DriverPerVehicleEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;
    @ManyToOne
    @JoinColumn(name = "state")
    private StatusEntity status;
}
