package ua.logos.dao;

import ua.logos.entity.CourseEntity;
import ua.logos.entity.TeacherEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAO {

    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    public void createCourse(CourseEntity course, TeacherEntity teacher) {

        if (teacher.getId() > 0) {
            course.setTeacher(teacher);
            em.persist(course);
        } else {
            System.out.println("Teacher ID not present");
        }
    }

    public List<CourseEntity> findAllCourses() {
        return
                em.createQuery("SELECT c FROM CourseEntity c WHERE c.isDeleted = :cDel", CourseEntity.class)
                    .setParameter("cDel", false).getResultList();
    }

    public List<CourseEntity> findAllCoursesByTeacherId(Long teacherId) {
        List<CourseEntity> courses =
            em.createQuery("SELECT c FROM CourseEntity c " +
                    "JOIN TeacherEntity t " +
                    "ON t = c.teacher " +
                    "WHERE t.id = :tId " +
                        "AND t.isDeleted = :tDel " +
                        "AND c.isDeleted = :cDel", CourseEntity.class)
                .setParameter("tId", teacherId)
                .setParameter("tDel", false)
                .setParameter("cDel", false)
                .getResultList();
        return courses;
    }

}
