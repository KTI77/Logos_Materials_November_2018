package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.entity.TeamEntity;
import ua.logos.repository.TeamRepository;
import ua.logos.service.TeamService;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void createTeam(TeamEntity team) {
        teamRepository.save(team);
    }

    @Override
    public List<TeamEntity> findAllTeams() {
        List<TeamEntity> teams =
                teamRepository.findAll();
        return teams;
    }
}
