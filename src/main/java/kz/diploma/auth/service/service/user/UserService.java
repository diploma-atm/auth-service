package kz.diploma.auth.service.service.user;

import kz.diploma.library.shared.model.entity.AdminEntity;
import kz.diploma.library.shared.model.entity.ClientEntity;

import java.util.Optional;

public interface UserService {
    Optional<AdminEntity> findAdmin(String phoneNumber);
    Optional<ClientEntity> findClient(String phoneNumber);
}
