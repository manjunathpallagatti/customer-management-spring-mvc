package com.practice.customermanagement.repository;

import com.practice.customermanagement.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer> {
    List<Customer> findByStatus(String status);
}
