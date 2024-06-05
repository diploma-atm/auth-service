package kz.diploma.auth.service.service.user;

import kz.diploma.library.shared.model.entity.AdminEntity;
import kz.diploma.library.shared.model.entity.ProductEntity;

import java.util.Optional;

public interface LoginService {
    Optional<AdminEntity> findAdmin(String phoneNumber);
    Optional<ProductEntity> findProduct(String pan);
}
