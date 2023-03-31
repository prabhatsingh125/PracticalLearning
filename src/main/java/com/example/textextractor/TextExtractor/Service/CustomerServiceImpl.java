package com.example.textextractor.TextExtractor.Service;

import com.example.textextractor.TextExtractor.Entity.Customer;
import com.example.textextractor.TextExtractor.Model.CustomerDto;
import com.example.textextractor.TextExtractor.Repository.CustomerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer findCustomerById(Long id) throws Exception {
        Customer customer = null;

        try {
            Optional<Customer> optCustomer = customerRepo.findById(id);
            if(optCustomer.isPresent()) {
                return optCustomer.get();
            }
        } catch (Exception e){
            throw new Exception("Customer not found");
        }
        return customer;
    }

    @Override
    public List<Customer> findAllCustomerByName(String name) throws Exception {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerRepo.findAllByCustomerName(name);
        return customerList;
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        Customer resultCustomer = customerRepo.save(customer);
        return resultCustomer;
    }
}
