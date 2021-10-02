package service;

import models.NotificationRequest;

import java.net.URISyntaxException;

public interface NotificationService {
    void sendNotificationToDeveloper(NotificationRequest request) throws URISyntaxException;
}
