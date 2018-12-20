package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.logos.entity.CourseEntity;

//@Repository
public interface CourseRepository
        extends JpaRepository<CourseEntity, Long> {
}
