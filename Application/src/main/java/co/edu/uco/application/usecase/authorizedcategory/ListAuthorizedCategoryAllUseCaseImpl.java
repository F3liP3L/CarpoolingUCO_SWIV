package co.edu.uco.application.usecase.authorizedcategory;

import co.edu.uco.entity.AuthorizedCategoryEntity;
import co.edu.uco.port.input.bussiness.authorizedcategory.ListAuthorizedCategoryAllUseCase;
import co.edu.uco.port.output.repository.AuthorizedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListAuthorizedCategoryAllUseCaseImpl implements ListAuthorizedCategoryAllUseCase {

    @Autowired
    private AuthorizedCategoryRepository repository;

    @Override
    public List<AuthorizedCategoryEntity> execute(Optional<AuthorizedCategoryEntity> dto) {
        return repository.findAll();
    }
}
