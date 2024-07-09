package com.bforbank.test.javatest.repository;

import com.bforbank.test.javatest.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
