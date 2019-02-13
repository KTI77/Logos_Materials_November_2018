package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity {

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    /*@ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> courses;*/

}
