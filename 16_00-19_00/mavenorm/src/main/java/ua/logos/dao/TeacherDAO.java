package ua.logos.dao;

import ua.logos.entity.CourseEntity;
import ua.logos.entity.TeacherEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class TeacherDAO {

    private EntityManager em;

    public TeacherDAO(EntityManager em) {
        this.em = em;
    }

    public void saveTeacher(TeacherEntity teacher) {
        em.persist(teacher);
        System.out.println("Teacher created with ID: " + teacher.getId());
    }

    public TeacherEntity findByTeacherId(Long id) {
        TeacherEntity teacherEntity =
                em.createQuery("SELECT t FROM TeacherEntity t WHERE t.id = :tId AND t.isDeleted = :tDel", TeacherEntity.class)
                    .setParameter("tId", id)
                        .setParameter("tDel", false)
                        .getSingleResult();
        return teacherEntity;
    }

    public List<TeacherEntity> findAllTeachers() {
        List<TeacherEntity> teachers =
                em.createQuery("SELECT t FROM TeacherEntity t WHERE t.isDeleted = :tDel", TeacherEntity.class)
                        .setParameter("tDel", false)
                        .getResultList();
        return  teachers;
    }


    public void deleteTeacherById(Long id) {
        em.createQuery("UPDATE TeacherEntity t SET t.isDeleted = :tDel WHERE t.id = :tId")
                .setParameter("tDel", true)
                .setParameter("tId", id)
                .executeUpdate();
        System.out.println("Teacher with id " + id + " deleted");
    }

    public TeacherEntity updateTeacher(TeacherEntity teacherEntity) {
        em.merge(teacherEntity);
        System.out.println("Entity updated");
        return teacherEntity;
    }

    public List<CourseEntity> findAllCourseByTeacherId(Long id) {
        return
                em.createQuery(
                        "SELECT c FROM CourseEntity c JOIN TeacherEntity t ON c.teacher = t WHERE t.id = :tId", CourseEntity.class)
                    .setParameter("tId", id).getResultList();
    }

}
