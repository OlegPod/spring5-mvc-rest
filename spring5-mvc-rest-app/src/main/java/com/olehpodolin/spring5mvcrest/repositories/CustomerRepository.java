package com.olehpodolin.spring5mvcrest.repositories;

import com.olehpodolin.spring5mvcrest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
