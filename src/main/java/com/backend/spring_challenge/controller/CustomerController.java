package com.backend.spring_challenge.controller;

import com.backend.spring_challenge.domain.AgeMeanKPI;
import com.backend.spring_challenge.domain.AgeStdKPI;
import com.backend.spring_challenge.domain.Customer;
import com.backend.spring_challenge.domain.KPI;
import com.backend.spring_challenge.dto.CustomerDTO;
import com.backend.spring_challenge.service.CustomerService;
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
    
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> listCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/customers",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Customer createCustomer(@RequestParam CustomerDTO customerDTO) {
        return customerService.create(customerDTO);
    }

    @RequestMapping(value = "/customers/kpi", method = RequestMethod.GET)
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
}
