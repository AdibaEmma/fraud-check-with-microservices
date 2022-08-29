package com.aweperi.customer;

import com.aweperi.clients.fraud.FraudCheckResponse;
import com.aweperi.clients.fraud.FraudClient;
import com.aweperi.clients.notification.NotificationClient;
import com.aweperi.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        var customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo: check if email is not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) throw new IllegalStateException("fraudster");

        // todo: make it async. i.e add to queue
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to AweperiServices...", customer.getFirstName())
                )
        );
    }
}
