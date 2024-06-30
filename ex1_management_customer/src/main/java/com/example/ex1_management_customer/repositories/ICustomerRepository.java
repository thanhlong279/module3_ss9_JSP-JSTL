package com.example.ex1_management_customer.repositories;

import com.example.ex1_management_customer.models.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();
}
