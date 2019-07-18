package com.intercorp.backendchallenge.controller;

import com.intercorp.backendchallenge.domain.AgeMeanKPI;
import com.intercorp.backendchallenge.domain.AgeStdKPI;
import com.intercorp.backendchallenge.domain.Customer;
import com.intercorp.backendchallenge.domain.KPI;
import com.intercorp.backendchallenge.dto.CustomerDTO;
import com.intercorp.backendchallenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/creacliente", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.create(customerDTO);
    }

    @RequestMapping(value = "/kpideclientes", method = RequestMethod.GET)
    public List<KPI> getKPIs() {
        return generateAllKPIs();
    }

    private List<KPI> generateAllKPIs() {
        List<KPI> KPIs = new ArrayList<>();
        AgeMeanKPI meanKPI = generateAgeMeanKPI();
        AgeStdKPI stdKPI = generateAgeStdKPI(Optional.ofNullable(meanKPI.getValue()));
        KPIs.add(meanKPI);
        KPIs.add(stdKPI);
        return KPIs;
    }

    private AgeMeanKPI generateAgeMeanKPI() {
        AgeMeanKPI ageMeanKPI = new AgeMeanKPI();
        ageMeanKPI.setValue(customerService.findAll().stream()
                .mapToDouble(Customer::getAge)
                .average()
                .getAsDouble());
        return ageMeanKPI;
    }

    private AgeStdKPI generateAgeStdKPI(Optional<Double> baseMean) {
        AgeStdKPI ageStdKPI = new AgeStdKPI();
        Double mean;
        Double squareMean = customerService.findAll().stream()
                .mapToDouble(customer -> Math.pow(customer.getAge(), 2))
                .average()
                .getAsDouble();

        mean = baseMean.orElseGet(() -> generateAgeMeanKPI().getValue());

        ageStdKPI.setValue(Math.sqrt(squareMean - Math.pow(mean, 2)));
        return ageStdKPI;
    }

    @RequestMapping(value = "/listclientes", method = RequestMethod.GET)
    public List<Customer> listCustomers() {
        return customerService.findAll();
    }
}
