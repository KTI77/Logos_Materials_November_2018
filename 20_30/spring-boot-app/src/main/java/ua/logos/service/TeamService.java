package ua.logos.service;

import ua.logos.entity.TeamEntity;

import java.util.List;

public interface TeamService {

    void createTeam(TeamEntity team);

    List<TeamEntity> findAllTeams();

    TeamEntity findTeamById(Long id);

    TeamEntity updateTeam(Long id, TeamEntity entityToUpdate);
}
