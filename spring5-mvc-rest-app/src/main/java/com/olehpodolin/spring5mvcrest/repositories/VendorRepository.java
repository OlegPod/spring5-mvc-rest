package com.olehpodolin.spring5mvcrest.repositories;

import com.olehpodolin.spring5mvcrest.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
