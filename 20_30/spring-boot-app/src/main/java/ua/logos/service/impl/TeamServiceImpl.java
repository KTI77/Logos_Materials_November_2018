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

    @Override
    public TeamEntity findTeamById(Long id) {
        boolean exists = teamRepository.existsById(id);
        if (!exists) {
            return null;
        }

        TeamEntity team = teamRepository.findById(id).get();
        return team;
    }

    @Override
    public TeamEntity updateTeam(Long id, TeamEntity entityToUpdate) {
        boolean exists = teamRepository.existsById(id);
        if(!exists) {
            return null;
        }

        TeamEntity teamFromDB = teamRepository.findById(id).get();
        teamFromDB.setName(entityToUpdate.getName());
        teamFromDB.setEngine(entityToUpdate.getEngine());
        teamRepository.save(teamFromDB);
        return teamFromDB;
    }
}
