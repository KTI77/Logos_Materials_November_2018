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
        boolean exists = teacherRepository.existsById(id);
        if (exists) {
            TeacherEntity teacherEntity = teacherRepository.findById(id).get();
            return teacherEntity;
        } else {
            return null;
        }
    }

    @Override
    public List<TeacherEntity> findAllTeachers() {
        List<TeacherEntity> teacherEntities =
                teacherRepository.findAll();
        return teacherEntities;
    }

    @Override
    public TeacherEntity updateTeacherById(Long id, TeacherEntity teacherToUpdate) {
        boolean exists = teacherRepository.existsById(id);
        boolean existsByEmail = teacherRepository.existsByEmail(teacherToUpdate.getEmail());

        if (!exists || existsByEmail) {
            return null;
        }

        TeacherEntity teacherFromDB = teacherRepository.findById(id).get();
        teacherFromDB.setFirstName(teacherToUpdate.getFirstName());
        teacherFromDB.setLastName(teacherToUpdate.getLastName());
        teacherFromDB.setEmail(teacherToUpdate.getEmail());
        teacherRepository.save(teacherFromDB);
        return teacherFromDB;
    }
}
