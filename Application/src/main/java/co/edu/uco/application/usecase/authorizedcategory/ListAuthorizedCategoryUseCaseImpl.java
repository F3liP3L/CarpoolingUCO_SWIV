package co.edu.uco.application.usecase.authorizedcategory;

import co.edu.uco.entity.AuthorizedCategoryEntity;
import co.edu.uco.port.input.bussiness.authorizedcategory.ListAuthorizedCategoryUseCase;
import co.edu.uco.port.output.repository.AuthorizedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListAuthorizedCategoryUseCaseImpl implements ListAuthorizedCategoryUseCase {
    @Autowired
    private AuthorizedCategoryRepository authorizedCategoryRepository;

    @Override
    public AuthorizedCategoryEntity execute(AuthorizedCategoryEntity domain) {
        Optional<AuthorizedCategoryEntity> authorizedCategoryEntity = authorizedCategoryRepository.findById(domain.getId());
        return authorizedCategoryEntity.get();
    }
}
