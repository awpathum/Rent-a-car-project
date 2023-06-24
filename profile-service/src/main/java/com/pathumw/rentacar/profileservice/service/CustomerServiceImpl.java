package com.pathumw.rentacar.profileservice.service;

import com.pathumw.rentacar.commons.model.Customer;
import com.pathumw.rentacar.profileservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        String errorStr = "No Customers found with id " + id;
        return customerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(errorStr));
    }
}
