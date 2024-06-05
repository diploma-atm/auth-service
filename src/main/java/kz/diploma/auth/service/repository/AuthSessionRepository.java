package kz.diploma.auth.service.repository;

import kz.diploma.library.shared.model.entity.auth.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AuthSessionRepository extends JpaRepository<AuthEntity, Long> {
    @Modifying
    @Transactional
    @Query("""
          UPDATE AuthEntity e SET e.terminatedDate = instant
            WHERE e.login = :login
             AND e.terminatedDate IS null
             """)
    void closeByLogin(@Param("login") String login);


    @Modifying
    @Transactional
    @Query("""
          UPDATE AuthEntity e SET e.terminatedDate = instant
            WHERE e.apiKey = :apiKey
             AND e.terminatedDate IS null
             """)
    void closeByToken(@Param("apiKey") String apiKey);

    Optional<AuthEntity> findByApiKey(String apiKey);
}
