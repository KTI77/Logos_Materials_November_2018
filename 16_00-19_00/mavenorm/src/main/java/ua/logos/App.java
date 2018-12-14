package ua.logos;

import ua.logos.dao.TeacherDAO;
import ua.logos.entity.CourseEntity;
import ua.logos.entity.TeacherEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();

        TeacherDAO teacherDAO = new TeacherDAO(em);

        em.getTransaction().begin();

        TeacherEntity teacherEntity = TeacherEntity
                            .builder()
                                .firstName("Tom")
                                .lastName("Tompson")
                                .email("tommy@gmail.com")
                            .build();
        //teacherDAO.saveTeacher(teacherEntity);

        teacherEntity = teacherDAO.findByTeacherId(2L);
        System.out.println(teacherEntity);

        teacherDAO.findAllTeachers().forEach(System.out::println);

        //teacherDAO.deleteTeacherById(teacherEntity.getId());


        teacherEntity.setFirstName("sdjhfsdkfjsdfkd");
        System.out.println(teacherDAO.updateTeacher(teacherEntity));

        teacherDAO.findAllCourseByTeacherId(teacherEntity.getId()).forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}

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

        /*CourseEntity course =
                em.createQuery("SELECT c FROM CourseEntity c WHERE c.id = :courseId AND c.title = :courseTitle", CourseEntity.class)
                    .setParameter("courseId", 2L)
                    .setParameter("courseTitle", "Hibernate/JPA")
                    .getSingleResult();
        System.out.println(course);*/
