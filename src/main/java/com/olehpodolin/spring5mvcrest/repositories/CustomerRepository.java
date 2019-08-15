package com.olehpodolin.spring5mvcrest.repositories;

import com.olehpodolin.spring5mvcrest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);

}
