package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.entity.TeacherEntity;
import ua.logos.repository.TeacherRepository;
import ua.logos.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void saveTeacher(TeacherEntity teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public TeacherEntity findTeacherById(Long id) {
        TeacherEntity teacherEntity = teacherRepository.findById(id).get();
        return teacherEntity;
    }

    @Override
    public List<TeacherEntity> findAllTeachers() {
        List<TeacherEntity> teacherEntities =
                teacherRepository.findAll();
        return teacherEntities;
    }
}
