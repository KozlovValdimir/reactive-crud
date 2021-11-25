package com.vkozlov.reactivecrud.repository;

import com.vkozlov.reactivecrud.entity.Customer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends R2dbcRepository<Customer, Long> {
}
