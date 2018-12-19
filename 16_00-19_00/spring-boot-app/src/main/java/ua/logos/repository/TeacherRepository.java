package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.logos.entity.TeacherEntity;

@Repository
public interface TeacherRepository
        extends JpaRepository<TeacherEntity, Long> {

    //@Query("SELECT t FROM TeacherEntity t WHERE t.email = :email")
    TeacherEntity findByEmail(String email);

}
