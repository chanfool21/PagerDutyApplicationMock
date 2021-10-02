package controller;
import models.CreateTeamRequest;
import models.CreateTeamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @PostMapping(path= "/create", consumes = "application/json", produces = "application/json")
    CreateTeamResponse createTeam(@RequestBody CreateTeamRequest requestParams ) throws Exception {
        String teamId = teamService.createTeam(requestParams.getTeam(), requestParams.getDeveloperList());
        CreateTeamResponse teamResponse = new CreateTeamResponse();
        teamResponse.setTeamId(teamId);
        teamResponse.setMessage("Team Created Successfully!!");
        return teamResponse;
    }
}
