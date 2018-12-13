package ua.logos;

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

        em.getTransaction().begin();

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

        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}
