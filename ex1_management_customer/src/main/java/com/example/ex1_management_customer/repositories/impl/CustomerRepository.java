package com.example.ex1_management_customer.repositories.impl;

import com.example.ex1_management_customer.models.Customer;
import com.example.ex1_management_customer.repositories.ICustomerRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static CustomerRepository instance;

    private CustomerRepository() {
    }

    public static synchronized CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(14, "Tuấn", LocalDate.of(1994, 9, 15), "Hà Nội", "<img src=\"chuyện cười.jpg\"width=\"90\" height=\"60\">"));
        customers.add(new Customer(3, "Nam", LocalDate.of(1995, 4, 17), "Hà Nội", "ádasda"));
        customers.add(new Customer(11, "Sơn", LocalDate.of(1993, 1, 13), "Hà Nội", "ádasda"));
        customers.add(new Customer(6, "Toàn", LocalDate.of(1997, 6, 11), "Hà Nội", "ádasda"));
//        customers.add(new Customer(14, "Tuấn", "Hà Nội", "ádasda"));
//        customers.add(new Customer(3, "Nam", "Hà Nội", "ádasda"));
//        customers.add(new Customer(11, "Sơn", "Hà Nội", "ádasda"));
//        customers.add(new Customer(6, "Toàn", "Hà Nội", "ádasda"));
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
}
