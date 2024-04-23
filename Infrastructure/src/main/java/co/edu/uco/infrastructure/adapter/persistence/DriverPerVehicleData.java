package co.edu.uco.infrastructure.adapter.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "driver_per_vehicle")
public class DriverPerVehicleData {
    @Id
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleData vehicle;
    @ManyToOne
    @JoinColumn(name = "state")
    private StatusData status;
}
