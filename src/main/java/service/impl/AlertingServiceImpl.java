package service.impl;

import models.Developer;
import models.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AlertingService;
import service.NotificationService;
import service.TeamService;

@Service
public class AlertingServiceImpl implements AlertingService {
    @Autowired
    private TeamService teamService;
    @Autowired
    private NotificationService notificationService;

    @Override
    public void sendAlert(String teamId) throws Exception {
        Developer developer = teamService.getDeveloperByTeamId(teamId);
        NotificationRequest request = new NotificationRequest();
        request.setId("xxx123");
        request.setMessage("[Prod Alert] xxx service down");
        request.setPhoneNumber(developer.getPhoneNumber());

        try {
            notificationService.sendNotificationToDeveloper(request);
        } catch(Exception e) {
            throw new Exception("Error while sending notification alert to developer");
        }
    }
}
