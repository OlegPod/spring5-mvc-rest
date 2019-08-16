package com.olehpodolin.spring5mvcrest.services;

import com.olehpodolin.spring5mvcrest.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long Id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

}
