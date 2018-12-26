package ua.logos.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.TeamDTO;
import ua.logos.entity.TeamEntity;
import ua.logos.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody TeamDTO team
            ) {
        teamService.createTeam(team);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<TeamDTO> teams = teamService.findAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("{teamId}")
    public ResponseEntity<?> findById(
            @PathVariable("teamId") Long id
    ) {
        TeamDTO team = teamService.findTeamById(id);

        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PutMapping("{teamId}")
    public ResponseEntity<?> updateTeam(
            @PathVariable("teamId") Long id,
            @RequestBody TeamDTO teamDTO
    ) {
        TeamDTO team = teamService.updateTeam(id, teamDTO);

        if (team == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(team, HttpStatus.OK);
    }
}
