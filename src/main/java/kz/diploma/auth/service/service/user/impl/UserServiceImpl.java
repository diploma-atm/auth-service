package kz.diploma.auth.service.service.user.impl;

import kz.diploma.auth.service.service.user.UserService;
import kz.diploma.library.shared.model.entity.AdminEntity;
import kz.diploma.library.shared.model.entity.ClientEntity;
import kz.diploma.library.shared.model.repository.AdminRepository;
import kz.diploma.library.shared.model.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AdminRepository adminRepository;

    private final ClientRepository clientRepository;

    @Override
    public Optional<AdminEntity> findAdmin(String phoneNumber) {
        return adminRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<ClientEntity> findClient(String phoneNumber) {
        return clientRepository.findClientByPhoneNumber(phoneNumber);
    }
}
