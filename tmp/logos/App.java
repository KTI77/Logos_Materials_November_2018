package ua.logos;

import ua.logos.dao.CourseDAO;
import ua.logos.dao.TeacherDAO;
import ua.logos.entity.Course;
import ua.logos.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        TeacherDAO teacherDAO = new TeacherDAO(em);
        CourseDAO courseDAO = new CourseDAO(em);

        // Teacher Entity
        Teacher teacher = Teacher.builder().firstName("John").lastName("Doe").email("john.doe@gmail.com").build();
        teacherDAO.saveTeacher(teacher);
        System.out.println(teacher.getId());

        System.out.println(teacherDAO.findTeacherById(1L)); // find one
        teacherDAO.findAllTeachers().forEach(System.out::println); // find all

        Teacher teacher2 = Teacher
                .builder()
                    .firstName("John2")
                    .lastName("Doe2")
                    .email("john.doe2@gmail.com")
                .build();
        teacher2.setId(teacher.getId());
        teacher2 = teacherDAO.updateTeacher(teacher2);
        System.out.println(teacher2);
        //teacherDAO.deleteTeacher(1L);


        // CourseEntity
        Course course = new Course().builder().title("MySQL for beginners").price(new BigDecimal("100")).build();

        courseDAO.saveCourse(teacher2, course);

        courseDAO.findAllCourses().forEach(System.out::println);
        System.out.println(courseDAO.findCourseById(1L));

        courseDAO.findCourseByTeacherId(1L).forEach(System.out::println);

        ////////////////////
        //teacherDAO.deleteTeacher(1L);
        ///////////////////

        //courseDAO.deleteCourseById(1L);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
