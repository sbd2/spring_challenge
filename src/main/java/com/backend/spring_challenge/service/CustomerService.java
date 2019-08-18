package com.backend.spring_challenge.service;

import com.backend.spring_challenge.exception.BadRequestException;
import com.backend.spring_challenge.dao.CustomerDAO;
import com.backend.spring_challenge.domain.Customer;
import com.backend.spring_challenge.dto.CustomerDTO;
import com.backend.spring_challenge.utils.DateUtils;
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
