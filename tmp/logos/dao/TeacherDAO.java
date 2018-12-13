package ua.logos.dao;

import ua.logos.entity.Teacher;

import javax.persistence.EntityManager;
import java.util.List;

public class TeacherDAO {

    private EntityManager em;

    public TeacherDAO(EntityManager em) {
        this.em = em;
    }

    public void saveTeacher(Teacher teacher) {
        em.persist(teacher);
        System.out.println("Teacher created. " + teacher);
    }

    public Teacher findTeacherById(Long id) {
        Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.id = :tId AND t.isDeleted = :tDel", Teacher.class)
                .setParameter("tId", id)
                .setParameter("tDel", false)
                .getSingleResult();
        return teacher;
    }

    public List<Teacher> findAllTeachers() {
        List<Teacher> teachers =
                    em.createQuery("SELECT t FROM Teacher t WHERE t.isDeleted = :tDel", Teacher.class)
                            .setParameter("tDel", false)
                            .getResultList();
        return teachers;
    }


    public Teacher updateTeacher(Teacher teacher) {
        if (teacher.getId() == null && teacher.getId() == 0) {
            System.out.println("No ID present. Can not update row");
            return null;
        }

        em.merge(teacher);
        System.out.println("Teacher updated. New data: " + teacher);
        return findTeacherById(teacher.getId());
    }

    public void deleteTeacher(Long id) {
        if (id == null && id == 0) {
            System.out.println("Problem with id");
            return;
        }

        /*em.createQuery("DELETE FROM Teacher t WHERE t.id = :tId")
                .setParameter("tId", id).executeUpdate();*/
        em.createQuery("UPDATE Teacher t SET t.isDeleted = :tDel WHERE t.id = :tId", Teacher.class)
                .setParameter("tDel", true)
                .setParameter("tId", id)
                .executeUpdate();
        System.out.println("Teacher with id " + id + " deleted");
    }
}
