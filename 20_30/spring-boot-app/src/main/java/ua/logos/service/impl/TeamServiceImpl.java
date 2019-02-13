package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.TeamDTO;
import ua.logos.entity.TeamEntity;
import ua.logos.repository.TeamRepository;
import ua.logos.service.TeamService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void createTeam(TeamDTO teamDTO) {

        /*TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName(teamDTO.getName());
        teamEntity.setEngine(teamDTO.getEngine());*/
        TeamEntity teamEntity = modelMapper.map(teamDTO, TeamEntity.class);
        teamRepository.save(teamEntity);
    }

    @Override
    public List<TeamDTO> findAllTeams() {
        List<TeamEntity> teams = teamRepository.findAll();
        List<TeamDTO> teamDTOs = modelMapper.mapAll(teams, TeamDTO.class);
        return teamDTOs;
    }

    @Override
    public TeamDTO findTeamById(Long id) {
        boolean exists = teamRepository.existsById(id);
        if (!exists) {
            return null;
        }

        TeamEntity team = teamRepository.findById(id).get();
        TeamDTO teamDTO = modelMapper.map(team, TeamDTO.class);
        return teamDTO;
        //return modelMapper.map(teamRepository.findById(id).get(), TeamDTO.class);
    }

    @Override
    public TeamDTO updateTeam(Long id, TeamDTO dtoToUpdate) {
        boolean exists = teamRepository.existsById(id);
        if(!exists) {
            return null;
        }

        TeamEntity teamFromDB = teamRepository.findById(id).get();
        /*teamFromDB.setName(entityToUpdate.getName());
        teamFromDB.setEngine(entityToUpdate.getEngine());*/

        teamFromDB = modelMapper.map(dtoToUpdate, TeamEntity.class);
        teamFromDB.setId(id);
        teamRepository.save(teamFromDB);

        TeamDTO teamDTO = modelMapper.map(teamFromDB, TeamDTO.class);
        return teamDTO;
    }
}
