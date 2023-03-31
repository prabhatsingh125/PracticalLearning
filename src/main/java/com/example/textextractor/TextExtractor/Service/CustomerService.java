package com.example.textextractor.TextExtractor.Service;

import com.example.textextractor.TextExtractor.Entity.Customer;
import com.example.textextractor.TextExtractor.Model.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CustomerService {

    Customer findCustomerById(Long id) throws Exception;
    List<Customer> findAllCustomerByName(String name) throws Exception;
    Customer saveCustomer(CustomerDto customerDto) throws Exception;
}
