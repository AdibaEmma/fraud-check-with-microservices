package com.aweperi.notification;

import com.aweperi.clients.notification.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}
