package com.pathumw.rentacar.profileservice.controller;

import com.pathumw.rentacar.commons.model.Customer;
import com.pathumw.rentacar.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {
    @Autowired
    CustomerService customerService;
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public Customer fetch(@PathVariable(value = "id") int id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Customer> fetch(){
        return customerService.getAllCustomers();
    }

}
