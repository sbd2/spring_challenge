package com.intercorp.backendchallenge.dao;

import com.intercorp.backendchallenge.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
