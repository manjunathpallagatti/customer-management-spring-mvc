package com.practice.customermanagement.service;

import com.practice.customermanagement.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAllCustomers();
    void registerCustomer(Customer customer);
    void deleteCustomer(Integer id);
    void updateCustomer(Customer customer);
    Customer getCustomerById(Integer id);
    List<Customer> getCustomersByStatus(String status);
}
