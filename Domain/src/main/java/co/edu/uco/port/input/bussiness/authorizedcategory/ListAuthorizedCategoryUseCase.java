package co.edu.uco.port.input.bussiness.authorizedcategory;

import co.edu.uco.entity.AuthorizedCategoryEntity;
import co.edu.uco.port.input.bussiness.FindUseCase;

import java.util.UUID;

public interface ListAuthorizedCategoryUseCase extends FindUseCase<AuthorizedCategoryEntity, UUID> {
}
