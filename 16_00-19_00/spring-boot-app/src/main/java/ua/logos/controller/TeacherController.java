package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.logos.service.TeacherService;

@RestController
@RequestMapping("teachers") // localhost:8080/teachers/**
public class TeacherController {

    @Autowired
    private TeacherService teacherService;




}
