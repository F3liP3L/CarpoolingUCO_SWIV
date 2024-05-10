package co.edu.uco.port.output.repository;

import co.edu.uco.entity.StatusEntity;

public interface StatusRepository {
    StatusEntity findByStatus(String status);
}
