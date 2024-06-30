package com.example.ex1_management_customer.controllers;

import com.example.ex1_management_customer.models.Customer;
import com.example.ex1_management_customer.services.ICustomerService;
import com.example.ex1_management_customer.services.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/list")
public class CustomerController extends HttpServlet {
    ICustomerService customerService = CustomerService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        req.setAttribute("lists", customers);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
