package dao.impl;

import constants.ErrorMessages;
import dao.TeamDao;
import models.Team;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TeamDaoImpl implements TeamDao {
    Map<String, Team> teamMap;

    public TeamDaoImpl() {
        teamMap = new HashMap<String, Team>();
    }

    @Override
    public void addTeam(Team team) throws Exception {
        if(teamMap.containsKey(team.getId())) {
            System.out.println("Team Id already exists");
            throw new Exception(ErrorMessages.ID_ALREADY_EXISTS.getMessage());
        } else {
            teamMap.put(team.getId(), team);
        }
    }

    @Override
    public Team getTeamById(String id) throws Exception {
        if(teamMap.containsKey(id)) {
            return teamMap.get(id);
        } else {
            throw new Exception(ErrorMessages.TEAM_DOES_NOT_EXIST.getMessage());
        }
    }
}
