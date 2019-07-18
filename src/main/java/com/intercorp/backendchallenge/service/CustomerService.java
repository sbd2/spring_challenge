package com.intercorp.backendchallenge.service;

import com.intercorp.backendchallenge.dao.CustomerDAO;
import com.intercorp.backendchallenge.domain.Customer;
import com.intercorp.backendchallenge.dto.CustomerDTO;
import com.intercorp.backendchallenge.exception.BadRequestException;
import com.intercorp.backendchallenge.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer create(CustomerDTO customerDTO) {
        validateCustomer(customerDTO);
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAge(customerDTO.getAge());
        customer.setBirthday(customerDTO.getBirthday());
        customer.setDeathday(DateUtils.addYears(customerDTO.getBirthday(),
                DateUtils.WORLD_LIFE_EXPECTANCY));
        return customerDAO.insert(customer);
    }

    public List<Customer> findAll() {
        List<Customer> customers = customerDAO.findAll();
        return customers != null ? customers : new ArrayList<>();
    }

    private void validateCustomer(CustomerDTO customerDTO) {
        if (customerDTO.getName() == null || customerDTO.getLastName() == null ||
        customerDTO.getAge() == 0 || customerDTO.getBirthday() == null) {
            throw new BadRequestException("All fields are required");
        }
    }
}
