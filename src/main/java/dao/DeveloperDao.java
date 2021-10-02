package dao;

import models.Developer;

import java.util.List;

public interface DeveloperDao {
    void addDeveloper(Developer developer);
    List<Developer> getDeveloperByTeamId(String teamId) throws Exception;
}
