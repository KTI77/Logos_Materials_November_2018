package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.entity.PilotEntity;
import ua.logos.repository.PilotRepository;
import ua.logos.service.PilotService;

import java.util.List;

@Service
public class PilotServiceImpl implements PilotService {

    @Autowired
    private PilotRepository pilotRepository;

    @Override
    public void savePilot(PilotEntity pilot) {
        pilotRepository.save(pilot);
    }

    @Override
    public List<PilotEntity> findAllPilots() {
        return pilotRepository.findAll();
    }
}
