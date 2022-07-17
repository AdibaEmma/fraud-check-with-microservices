package com.aweperi.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() implements ICustomerService {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo: check if email is not taken
        // todo: store customer in db
    }
}
