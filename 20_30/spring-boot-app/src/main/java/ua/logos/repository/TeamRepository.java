package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.logos.entity.TeamEntity;

@Repository
public interface TeamRepository
        extends JpaRepository<TeamEntity, Long> {

    // select count(*) from teams where id = ?
    boolean existsById(Long id);

}
