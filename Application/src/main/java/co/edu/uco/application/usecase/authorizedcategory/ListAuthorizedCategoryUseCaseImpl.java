package co.edu.uco.application.usecase.authorizedcategory;

import co.edu.uco.entity.AuthorizedCategoryEntity;
import co.edu.uco.port.input.bussiness.authorizedcategory.ListAuthorizedCategoryUseCase;
import co.edu.uco.port.output.repository.AuthorizedCategoryRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ListAuthorizedCategoryUseCaseImpl implements ListAuthorizedCategoryUseCase {

    private final AuthorizedCategoryRepository authorizedCategoryRepository;

    public ListAuthorizedCategoryUseCaseImpl(AuthorizedCategoryRepository authorizedCategoryRepository) {
        this.authorizedCategoryRepository = authorizedCategoryRepository;
    }

    @Override
    public AuthorizedCategoryEntity execute(UUID id) {
        Optional<AuthorizedCategoryEntity> authorizedCategoryEntity = authorizedCategoryRepository.findById(id);
        if (authorizedCategoryEntity.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The authorized category does not exist in the application.");
        }
        return authorizedCategoryEntity.get();
    }
}
