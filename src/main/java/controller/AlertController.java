package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AlertingService;

@RestController
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    private AlertingService alertService;

    @PostMapping("/send")
    String sendAlert(@RequestBody String teamId) throws Exception {
        alertService.sendAlert(teamId);
        return "Alert Sent Successfully!!";
    }

}
