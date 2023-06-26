package com.pathumw.rentacar.profileservice.service;

import com.pathumw.rentacar.commons.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
}
