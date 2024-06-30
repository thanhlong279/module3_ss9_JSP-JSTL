package com.example.ex1_management_customer.services;

import com.example.ex1_management_customer.models.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
}
