package co.edu.uco.infrastructure.adapter.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "vehicle")
public class VehicleData {
    @Id
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverData owner;
    @Column(name = "name")
    private String name;
    @Column(name = "plate")
    private String plate;
    @Column(name = "quota")
    private int capacity;

}
