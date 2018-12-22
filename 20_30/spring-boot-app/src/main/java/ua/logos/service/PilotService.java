package ua.logos.service;

import ua.logos.entity.PilotEntity;

import java.util.List;

public interface PilotService {

    void savePilot(PilotEntity pilot);

    List<PilotEntity> findAllPilots();
}
