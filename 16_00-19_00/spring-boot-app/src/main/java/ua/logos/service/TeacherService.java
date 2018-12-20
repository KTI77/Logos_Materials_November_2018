package ua.logos.service;

import ua.logos.entity.TeacherEntity;

import java.util.List;

public interface TeacherService {

    void saveTeacher(TeacherEntity teacher);

    TeacherEntity findTeacherById(Long id);

    List<TeacherEntity> findAllTeachers();

    TeacherEntity updateTeacherById(Long id, TeacherEntity teacherToUpdate);
}
