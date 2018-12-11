package ua.logos;

import ua.logos.entity.CourseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        /*CourseEntity courseEntity = new CourseEntity();
        courseEntity.setTitle("Hibernate/JPA");
        courseEntity.setDescription("empty ...");
        courseEntity.setPrice(new BigDecimal(199.99));
        courseEntity.setImage("logo.png");
        System.out.println("1." + courseEntity);
        em.persist(courseEntity);
        System.out.println("2." + courseEntity);*/

        /*
        List<CourseEntity> courses =
                em.createQuery("SELECT c FROM CourseEntity c", CourseEntity.class)
                    .getResultList();
        courses.forEach(System.out::println);
        */

        CourseEntity course =
                em.createQuery("SELECT c FROM CourseEntity c WHERE c.id = :courseId AND c.title = :courseTitle", CourseEntity.class)
                    .setParameter("courseId", 2L)
                    .setParameter("courseTitle", "Hibernate/JPA")
                    .getSingleResult();
        System.out.println(course);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
