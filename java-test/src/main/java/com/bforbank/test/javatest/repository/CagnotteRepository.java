package com.bforbank.test.javatest.repository;

import com.bforbank.test.javatest.entity.Cagnotte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CagnotteRepository extends JpaRepository<Cagnotte, Long> {
    Optional<Cagnotte> findByClientId(Long clientId);
}
