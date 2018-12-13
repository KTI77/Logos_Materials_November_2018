package ua.logos.dao;

import ua.logos.entity.Course;
import ua.logos.entity.Teacher;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAO {
    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    public void  saveCourse(Teacher teacher, Course course) {
        if (teacher.getId() != 0 && teacher.getId() != null) {
            course.setTeacher(teacher);
            em.persist(course);
            System.out.println("Course created. " + course);
        }
    }

    public List<Course> findAllCourses() {
        return em.createQuery("SELECT c FROM Course c WHERE c.isDeleted = :cDel", Course.class)
                .setParameter("cDel", false)
                .getResultList();
    }

    public Course findCourseById(Long id) {
        if (id == null && id <= 0) {
            System.out.println("Id can not be null or <=0");
            return null;
        }
        return em.createQuery("SELECT c FROM Course c WHERE c.id = :cId", Course.class)
                .setParameter("cId", id).getSingleResult();
    }

    public List<Course> findCourseByTeacherId(Long teacherId) {
        return em.createQuery("SELECT c FROM Course c JOIN Teacher t ON t = c.teacher WHERE t.id = :tId", Course.class)
                .setParameter("tId", teacherId).getResultList();
    }

    public void deleteCourseById(Long id) {
        //em.createQuery("DELETE from Course c WHERE c.id = :cId").setParameter("cId", id).executeUpdate();
        em.createQuery("UPDATE Course c SET c.isDeleted = :cDel WHERE c.id = :cId")
                .setParameter("cDel", true)
                .setParameter("cId", id)
                .executeUpdate();
        System.out.printf("Course with id " + id + "deleted");
    }
}
