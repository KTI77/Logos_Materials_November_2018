package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.entity.TeacherEntity;
import ua.logos.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("teachers") // localhost:8080/teachers/**
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping // localhost:8080/teachers
    public ResponseEntity<?> createTeacher(@RequestBody TeacherEntity teacher) {
        System.out.println(
                teacher.getFirstName() + " " +
                teacher.getLastName() + " " +
                teacher.getEmail()
        );
        teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeacherEntity>> getAllTeachers() {
        List<TeacherEntity> teachers =
                teacherService.findAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("{teacherId}") // localhost:8080/teachers/{id}
    public ResponseEntity<TeacherEntity> getTeacherInfoById(
            @PathVariable("teacherId") Long id
    ) {
        TeacherEntity teacher = teacherService.findTeacherById(id);

        if(teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{teacherId}")
    public ResponseEntity<?> updateTeacher(
            @PathVariable("teacherId") Long id,
            @RequestBody TeacherEntity teacherEntity
    ) {
        TeacherEntity teacher = teacherService.updateTeacherById(id, teacherEntity);
        if(teacher == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

}
