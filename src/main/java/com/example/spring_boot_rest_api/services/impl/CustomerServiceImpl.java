package com.example.spring_boot_rest_api.services.impl;

import com.example.spring_boot_rest_api.exceptions.EntityNotFoundException;
import com.example.spring_boot_rest_api.entities.Customer;
import com.example.spring_boot_rest_api.repositories.CustomerRepository;
import com.example.spring_boot_rest_api.services.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
    }

    @Transactional
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Transactional
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id).map(customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setEmail(updatedCustomer.getEmail());
                    return customerRepository.save(customer);
                }
        ).orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
    }

    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
