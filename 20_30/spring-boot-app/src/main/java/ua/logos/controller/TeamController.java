package ua.logos.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
            @RequestBody TeamEntity team
            ) {
        //System.out.println(team.getName() + " " + team.getEngine());
        teamService.createTeam(team);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<TeamEntity> teams = teamService.findAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
}
