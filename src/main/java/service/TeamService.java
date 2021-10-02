package service;

import models.Developer;
import models.Team;

import java.util.List;

public interface TeamService {
    String createTeam(Team team, List<Developer> developers) throws Exception;
    Team getTeamById(String teamId) throws Exception;
    Developer getDeveloperByTeamId(String teamId) throws Exception;
}
