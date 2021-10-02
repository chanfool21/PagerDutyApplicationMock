package dao;

import models.Team;

public interface TeamDao {
    void addTeam(Team team) throws Exception;
    Team getTeamById(String id) throws Exception;
}
