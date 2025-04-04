package com.example.spring_boot_rest_api.services;

import com.example.spring_boot_rest_api.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerById(Long id);
    List<Customer> findAllCustomers();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer updatedCustomer);
    void deleteCustomer(Long id);
}
