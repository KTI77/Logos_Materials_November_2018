package ua.logos.dao;

import ua.logos.entity.TeacherEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class TeacherDAO {

    private EntityManager em;

    public TeacherDAO(EntityManager em) {
        this.em = em;
    }

    public TeacherEntity saveTeacher(TeacherEntity teacherEntity) {
        em.persist(teacherEntity);
        return teacherEntity;
    }

    public List<TeacherEntity> findAllTeachers() {
        List<TeacherEntity> teachers =
                em.createQuery("SELECT t FROM TeacherEntity t WHERE t.isDeleted = :tDel", TeacherEntity.class)
                .setParameter("tDel", false)
                        .getResultList();
        return teachers;
    }

    public TeacherEntity findTeacherById(Long id) {
        TeacherEntity teacherEntity =
                em.createQuery("SELECT t FROM TeacherEntity t WHERE t.id = :tId AND t.isDeleted = :tDel", TeacherEntity.class)
                    .setParameter("tId", id)
                    .setParameter("tDel", false)
                        .getSingleResult();
        return teacherEntity;
    }

    public Long countTeachers() {
        Long count =
                em.createQuery("SELECT count(t.id) FROM TeacherEntity t", Long.class)
                        .getSingleResult();
        return count;
    }

    public void deleteTeacherById(Long id) {
        em.createQuery("UPDATE TeacherEntity t SET t.isDeleted = :tDel WHERE t.id = :tId")
                .setParameter("tDel", true)
                .setParameter("tId", id)
                .executeUpdate();
    }

}
