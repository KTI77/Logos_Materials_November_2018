package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.domain.PilotDTO;
import ua.logos.entity.PilotEntity;
import ua.logos.repository.PilotRepository;
import ua.logos.service.PilotService;
import ua.logos.utils.ObjectMapperUtils;

import java.util.List;

@Service
public class PilotServiceImpl implements PilotService {

    @Autowired
    private PilotRepository pilotRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void savePilot(PilotDTO pilot) {
        PilotEntity pilotEntity = modelMapper.map(pilot, PilotEntity.class);
        pilotRepository.save(pilotEntity);
    }

    @Override
    public List<PilotDTO> findAllPilots() {
        List<PilotEntity> pilotEntities = pilotRepository.findAll();
        List<PilotDTO> pilotDTOs = modelMapper.mapAll(pilotEntities, PilotDTO.class);
        return pilotDTOs;
    }
}
