package ua.logos.service;

import ua.logos.domain.PilotDTO;

import java.util.List;

public interface PilotService {

    void savePilot(PilotDTO pilot);

    List<PilotDTO> findAllPilots();
}
