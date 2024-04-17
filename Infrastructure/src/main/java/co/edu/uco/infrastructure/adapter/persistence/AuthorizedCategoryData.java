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
@Table(name = "authorized_category")
public class AuthorizedCategoryData {
    @Id
    private UUID id;
    @Column(name = "category")
    private String category;
}
