package service.impl;

import models.NotificationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.NotificationService;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class NotificationServiceImpl implements NotificationService {
    String notificationEndpoint = "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f";
    @Override
    public void sendNotificationToDeveloper(NotificationRequest request) throws URISyntaxException {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.postForEntity(new URI(notificationEndpoint), request, String.class);
        System.out.println(response.getBody());
    }
}
