package ua.logos;

import ua.logos.dao.CourseDAO;
import ua.logos.dao.TeacherDAO;
import ua.logos.entity.CourseEntity;
import ua.logos.entity.TeacherEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();

        TeacherDAO teacherDAO = new TeacherDAO(em);
        CourseDAO courseDAO = new CourseDAO(em);

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setFirstName("John");
        teacherEntity.setLastName("Doe");
        teacherEntity.setEmail("john.doe@gmail.com");

        TeacherEntity teacherEntity2 = new TeacherEntity();
        teacherEntity2.setFirstName("Tom");
        teacherEntity2.setLastName("Tompson");
        teacherEntity2.setEmail("tom@gmail.com");

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setTitle("MySQL");
        courseEntity.setPrice(new BigDecimal(99.99));
        courseEntity.setDescription("empty...");

        CourseEntity courseEntity1 = new CourseEntity();
        courseEntity1.setTitle("Spring Boot 2");
        courseEntity1.setPrice(new BigDecimal(199.99));
        courseEntity1.setDescription("empty...");

        em.getTransaction().begin();

        if (teacherDAO.countTeachers() == 0) {
            teacherDAO.saveTeacher(teacherEntity);
            teacherDAO.saveTeacher(teacherEntity2);

            courseDAO.createCourse(courseEntity, teacherEntity);
            courseDAO.createCourse(courseEntity1, teacherEntity);

        }

        courseDAO.findAllCourses().forEach(System.out::println);

        courseDAO.findAllCoursesByTeacherId(1L).forEach(System.out::println);

        //teacherDAO.findAllTeachers().forEach(System.out::println);
        //System.out.println(teacherDAO.findTeacherById(1L));

        //teacherDAO.deleteTeacherById(2L);
        //teacherDAO.findAllTeachers().forEach(System.out::println);
        //teacherDAO.findTeacherById(2L);

        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}

 /*TeacherEntity teacher = new TeacherEntity();
        teacher.setFirstName("John");
        teacher.setLastName("Doe");
        teacher.setEmail("john.doe@gmail.com");
        em.persist(teacher);

        CourseEntity course = new CourseEntity();
        course.setTitle("JPA/Hibernate");
        course.setDescription("empty .. ");
        course.setPrice(new BigDecimal(129.99));
        course.setTeacher(teacher);
        em.persist(course);*/

        /*CourseEntity courseEntity = new CourseEntity();
        courseEntity.setTitle("MySQL course");
        courseEntity.setDescription("Empty description ...");
        courseEntity.setPrice(new BigDecimal(49.99));

        System.out.println("1. " + courseEntity);
        em.persist(courseEntity);
        System.out.println("2. " + courseEntity);*/

        /*List<CourseEntity> courses =
                em.createQuery("SELECT c FROM CourseEntity c",
                        CourseEntity.class).getResultList();
        courses.forEach(System.out::println);

        CourseEntity course =
                em.createQuery(
                        "SELECT c FROM CourseEntity c " +
                                "WHERE c.id = :courseId", //  OR c.id = :courseId2
                        CourseEntity.class)
                        .setParameter("courseId", 2L) // new Long(2)
                        //.setParameter("courseId2", 1L)
                        .getSingleResult();
        System.out.println(course);
*/