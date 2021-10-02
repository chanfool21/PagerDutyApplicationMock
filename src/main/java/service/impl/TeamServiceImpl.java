package service.impl;

import dao.DeveloperDao;
import dao.TeamDao;
import models.Developer;
import models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TeamService;

import java.util.List;
import java.util.UUID;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;
    @Autowired
    private DeveloperDao developerDao;

    @Override
    public String createTeam(Team team, List<Developer> developers) throws Exception {
        String teamId = generateTeamId();
        team.setId(teamId);
        teamDao.addTeam(team);
        for(Developer developer: developers) {
            developer.setTeamId(teamId);
            developerDao.addDeveloper(developer);
        }
        return teamId;
    }

    @Override
    public Team getTeamById(String teamId) throws Exception {
        return teamDao.getTeamById(teamId);
    }


    @Override
    public Developer getDeveloperByTeamId(String teamId) throws Exception {
        List<Developer> developerList = getDevelopersByTeamId(teamId);
        int developerListSize = developerList.size();
        int index = (int) (Math.random() * (developerListSize));
        return developerList.get(index);
    }

    private  List<Developer> getDevelopersByTeamId(String teamId) throws Exception {
        return developerDao.getDeveloperByTeamId(teamId);
    }

    private String generateTeamId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0,9);
    }
}
