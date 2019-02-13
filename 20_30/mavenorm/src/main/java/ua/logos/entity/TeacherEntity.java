package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = {"courses", "teacherDetails"})

@Entity
@Table(name = "teachers") // teacher_entity
public class TeacherEntity extends BaseEntity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @OneToMany(mappedBy = "teacher")
    private List<CourseEntity> courses;

    @OneToOne(mappedBy = "teacher")
    private TeacherDetailsEntity teacherDetails;
}
