package com.vkozlov.reactivecrud.config;

import com.vkozlov.reactivecrud.handler.CustomerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CustomerRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(CustomerHandler customerHandler) {
        return route(RequestPredicates.GET("/functional"),
                customerHandler::root)
                .andRoute(RequestPredicates.GET("/functional/customer"),
                        customerHandler::all)
                .andRoute(RequestPredicates.POST("/functional/customer"),
                        customerHandler::all)
                .andRoute(RequestPredicates.PUT("/functional/customer"),
                        customerHandler::all)
                .andRoute(RequestPredicates.DELETE("/functional/customer"),
                        customerHandler::all);
    }
}
