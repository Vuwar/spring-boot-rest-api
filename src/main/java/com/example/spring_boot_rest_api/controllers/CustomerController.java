package com.example.spring_boot_rest_api.controllers;

import com.example.spring_boot_rest_api.entities.Customer;
import com.example.spring_boot_rest_api.services.impl.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer Management", description = "Operations related to Customers")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @Operation(summary = "Create a new customer")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Customer successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) {
        Customer newCustomer = customerServiceImpl.createCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @Operation(summary = "Get all customers")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Customers successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerServiceImpl.findAllCustomers();
            return ResponseEntity.ok(customers);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Get a customer by ID")
    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Customer successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        try {
            Customer customer = customerServiceImpl.findCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Update a customer")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Customer successfully updated"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer newCustomer, @PathVariable Long id) {
        try {
            Customer updatedCustomer = customerServiceImpl.updateCustomer(id, newCustomer);
            return ResponseEntity.ok(updatedCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a customer")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Customer successfully deleted"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerServiceImpl.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
