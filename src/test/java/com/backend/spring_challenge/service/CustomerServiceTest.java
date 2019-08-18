package com.backend.spring_challenge.service;

import com.backend.spring_challenge.domain.Customer;
import com.backend.spring_challenge.dto.CustomerDTO;
import com.backend.spring_challenge.exception.BadRequestException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test(expected = BadRequestException.class)
    public void validateNameRequired() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastName("foo");
        customerDTO.setAge(1);
        customerDTO.setBirthday(new Date());

        customerService.create(customerDTO);
    }

    @Test(expected = BadRequestException.class)
    public void validateLasNameRequired() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("foo");
        customerDTO.setAge(1);
        customerDTO.setBirthday(new Date());

        customerService.create(customerDTO);
    }

    @Test(expected = BadRequestException.class)
    public void validateAgeRequired() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("foo");
        customerDTO.setLastName("bar");
        customerDTO.setBirthday(new Date());

        customerService.create(customerDTO);
    }

    @Test(expected = BadRequestException.class)
    public void validateBirthdayRequired() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("foo");
        customerDTO.setLastName("bar");
        customerDTO.setAge(1);

        customerService.create(customerDTO);
    }

    @Test
    public void create() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("foo");
        customerDTO.setLastName("bar");
        customerDTO.setAge(1);
        customerDTO.setBirthday(new Date());

        Customer customer = customerService.create(customerDTO);

        Assert.assertNotNull(customer);
    }

    @Test
    public void findAll() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("foo");
        customerDTO.setLastName("bar");
        customerDTO.setAge(1);
        customerDTO.setBirthday(new Date());

        Customer customer = customerService.create(customerDTO);

        Assert.assertTrue(customerService.findAll().size() > 0);
    }
}