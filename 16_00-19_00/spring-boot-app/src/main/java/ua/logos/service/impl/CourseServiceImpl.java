package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.entity.CourseEntity;
import ua.logos.repository.CourseRepository;
import ua.logos.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void createCourse(CourseEntity course) {
        courseRepository.save(course);
    }

    @Override
    public List<CourseEntity> findAllCourses() {
        return courseRepository.findAll();
    }
}
