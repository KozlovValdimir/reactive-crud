package com.vkozlov.reactivecrud.handler;

import com.vkozlov.reactivecrud.entity.Customer;
import com.vkozlov.reactivecrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CustomerHandler {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Mono<ServerResponse> root(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Hello from functional controller!");
    }

    public Mono<ServerResponse> all(ServerRequest request) {
        return ServerResponse.ok().body(customerRepository.findAll(), Customer.class);
    }

    public Mono<ServerResponse> add(ServerRequest request) {
        Mono<Customer> data = request
                .bodyToMono(Customer.class)
                .doOnNext(customerRepository::save);

        return ServerResponse.ok().body(data, Customer.class);
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<Customer> data = request
                .bodyToMono(Customer.class)
                .doOnNext(customerRepository::save);

        return ServerResponse.ok().body(data, Customer.class);
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        Mono<Long> data = request
                .bodyToMono(Long.class)
                .doOnNext(customerRepository::deleteById);

        return ServerResponse.ok().build();
    }
}
