package com.vkozlov.reactivecrud.controller;

import com.vkozlov.reactivecrud.entity.Customer;
import com.vkozlov.reactivecrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public Flux<Customer> getAll() {
        return customerRepository.findAll();
    }

    @PostMapping
    public Mono<Customer> add(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping
    public Mono<Customer> update(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping
    public Mono<Void> delete(long id) {
        return customerRepository.deleteById(id);
    }
}
