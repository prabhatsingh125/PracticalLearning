package com.example.textextractor.TextExtractor.controller;

import com.example.textextractor.TextExtractor.Entity.Customer;
import com.example.textextractor.TextExtractor.Model.CustomerDto;
import com.example.textextractor.TextExtractor.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Using pathVariable
     */

    @GetMapping(value = "/customerById/{id}")
    ResponseEntity<?> getCustomerById(@PathVariable(name = "id") Long id) throws Exception {

        Customer customer = customerService.findCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    /**
     * using RequestParam
     */
    @GetMapping(value = "/customerByName")
    ResponseEntity<?> getCustomerByName(@RequestParam(name = "name") String name) throws Exception {

        List<Customer> customerList = customerService.findAllCustomerByName(name);
        return ResponseEntity.ok(customerList);
    }

    /**
     * using RequestBody
     */
    @PostMapping(value = "/saveCustomer")
    ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) throws Exception {

        Customer customer = customerService.saveCustomer(customerDto);
        return ResponseEntity.ok(customer);
    }






}

