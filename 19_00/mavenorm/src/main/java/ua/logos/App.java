package ua.logos;

import ua.logos.dao.TeacherDAO;
import ua.logos.entity.TeacherEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();

        TeacherDAO teacherDAO = new TeacherDAO(em);

        em.getTransaction().begin();

        teacherDAO.findAllTeachers().forEach(System.out::println);


        /*TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setFirstName("John");
        teacherEntity.setLastName("Doe");
        teacherEntity.setEmail("john.doe@gmail.com");
        em.persist(teacherEntity);

        TeacherEntity teacherEntity1 = new TeacherEntity();
        teacherEntity1.setFirstName("Petro");
        teacherEntity1.setLastName("Petrenko");
        teacherEntity1.setEmail("petrenko80@gmail.com");
        em.persist(teacherEntity1);

        TeacherEntity teacherEntity2 = new TeacherEntity();
        teacherEntity2.setFirstName("Tom");
        teacherEntity2.setLastName("Tompson");
        teacherEntity2.setEmail("tommy1991@gmail.com");
        em.persist(teacherEntity2);*/

        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
