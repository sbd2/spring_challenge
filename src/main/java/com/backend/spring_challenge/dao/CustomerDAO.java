package com.backend.spring_challenge.dao;

import com.backend.spring_challenge.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDAO {

    @Autowired
    private CustomerRepository repository;

    public Customer insert(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }
}
