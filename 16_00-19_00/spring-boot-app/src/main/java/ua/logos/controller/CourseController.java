package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.entity.CourseEntity;
import ua.logos.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CourseEntity course) {
        courseService.createCourse(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getCourses() {
        List<CourseEntity> courses =
                courseService.findAllCourses();
        //return ResponseEntity.ok(courses);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}
