package com.aweperi.clients.notification;

public record NotificationRequest(
        Long toCustomerId,
        String toCustomerEmail,
        String message
) {
}
