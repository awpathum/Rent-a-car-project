package com.pathumw.rentacar.profileservice.controller;

import com.pathumw.rentacar.commons.model.Customer;
import com.pathumw.rentacar.profileservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {
    @Autowired
    CustomerService customerService;
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam int id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }
}
