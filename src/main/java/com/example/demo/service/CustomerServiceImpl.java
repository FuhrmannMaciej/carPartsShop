package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Customer customerDB = customerRepository.findById(id).get();

        if (Objects.nonNull(customer.getFirstName()) && !customer.getFirstName().isEmpty()) {
            customerDB.setFirstName(customer.getFirstName());
        }

        if (Objects.nonNull(customer.getLastName()) && !customer.getLastName().isEmpty()) {
            customerDB.setLastName(customer.getLastName());
        }

        if (Objects.nonNull(customer.getEmail()) && !customer.getEmail().isEmpty()) {
            customerDB.setEmail(customer.getEmail());
        }

        if (Objects.nonNull(customer.getPhoneNumber()) && !customer.getPhoneNumber().isEmpty()) {
            customerDB.setPhoneNumber(customer.getPhoneNumber());
        }

        return customerRepository.save(customerDB);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
