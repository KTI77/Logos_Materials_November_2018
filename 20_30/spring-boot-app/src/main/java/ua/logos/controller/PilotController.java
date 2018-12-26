package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.PilotDTO;
import ua.logos.entity.PilotEntity;
import ua.logos.service.PilotService;

import java.util.List;

@RestController
@RequestMapping("pilots")
public class PilotController {

    @Autowired
    private PilotService pilotService;

    @PostMapping
    public ResponseEntity<?> createPilot(@RequestBody PilotDTO pilot) {
        pilotService.savePilot(pilot);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getPilots() {
        List<PilotDTO> pilots = pilotService.findAllPilots();
        return new ResponseEntity<>(pilots, HttpStatus.OK);
    }

}
