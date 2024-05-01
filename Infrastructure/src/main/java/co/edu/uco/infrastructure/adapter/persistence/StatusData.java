package co.edu.uco.infrastructure.adapter.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "status")
public class StatusData {
    @Id
    private UUID id;
    private String status;
}
