package ua.logos.service;

import ua.logos.domain.TeamDTO;

import java.util.List;

public interface TeamService {

    void createTeam(TeamDTO team);

    List<TeamDTO> findAllTeams();

    TeamDTO findTeamById(Long id);

    TeamDTO updateTeam(Long id, TeamDTO entityToUpdate);
}
