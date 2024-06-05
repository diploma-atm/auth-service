package kz.diploma.auth.service.service.user.impl;

import kz.diploma.auth.service.service.user.LoginService;
import kz.diploma.library.shared.model.entity.AdminEntity;
import kz.diploma.library.shared.model.entity.ProductEntity;
import kz.diploma.library.shared.model.repository.AdminRepository;
import kz.diploma.library.shared.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final AdminRepository adminRepository;
    private final ProductRepository productRepository;

    @Override
    public Optional<AdminEntity> findAdmin(String phoneNumber) {
        return adminRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<ProductEntity> findProduct(String pan) {
        return productRepository.findByPan(pan);
    }
}
