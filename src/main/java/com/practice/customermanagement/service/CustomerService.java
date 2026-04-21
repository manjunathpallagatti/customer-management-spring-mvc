package com.practice.customermanagement.service;

import com.practice.customermanagement.entity.Customer;
import com.practice.customermanagement.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepo.findAll();
    }

    @Override
    public void registerCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepo.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getCustomersByStatus(String status) {
        return customerRepo.findByStatus(status);
    }
}
