package com.example.ex1_management_customer.services.impl;

import com.example.ex1_management_customer.models.Customer;
import com.example.ex1_management_customer.repositories.ICustomerRepository;
import com.example.ex1_management_customer.repositories.impl.CustomerRepository;
import com.example.ex1_management_customer.services.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository = CustomerRepository.getInstance();
    private static CustomerService instance;

    private CustomerService() {
    }

    public synchronized static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.getAll();
    }
}
