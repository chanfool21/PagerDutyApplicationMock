package dao.impl;

import dao.DeveloperDao;
import models.Developer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DeveloperDaoImpl implements DeveloperDao {
    private static Map<String, List<Developer>> teamToDeveloperMap;

    public DeveloperDaoImpl() {
        teamToDeveloperMap = new HashMap<String, List<Developer>>();
    }

    @Override
    public void addDeveloper(Developer developer) {
        String teamId = developer.getTeamId();
        if(teamToDeveloperMap.containsKey(teamId)) {
            System.out.println("Adding developer to team: "+teamId);
            List<Developer> team = teamToDeveloperMap.get(teamId);
            team.add(developer);
            teamToDeveloperMap.put(teamId, team);
        } else {
            List<Developer> team = new ArrayList<Developer>();
            team.add(developer);
            teamToDeveloperMap.put(teamId, team);
            System.out.println("Developer added successfully");
        }
    }

    @Override
    public List<Developer> getDeveloperByTeamId(String teamId) throws Exception {
        if(teamToDeveloperMap.containsKey(teamId)) {
            return teamToDeveloperMap.get(teamId);
        } else {
            throw new Exception("Team doesn't exist");
        }
    }
}
