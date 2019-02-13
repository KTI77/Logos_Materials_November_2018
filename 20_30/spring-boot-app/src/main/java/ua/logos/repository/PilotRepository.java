package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.logos.entity.PilotEntity;

@Repository
public interface PilotRepository
        extends JpaRepository<PilotEntity, Long> {

}
