package ua.logos.service;

import ua.logos.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    void createCourse(CourseEntity course);

    List<CourseEntity> findAllCourses();

}
