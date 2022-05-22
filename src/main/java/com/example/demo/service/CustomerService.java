package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer, Long id);

    void deleteCustomer(Long id);

    Customer getCustomerById(Long id);
}
