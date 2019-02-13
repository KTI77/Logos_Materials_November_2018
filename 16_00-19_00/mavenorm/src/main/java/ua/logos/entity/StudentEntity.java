package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity {

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @OneToMany(mappedBy = "student")
    private List<StudentCourseEntity> studentCourses;

    /*@ManyToMany
    @JoinTable(name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> courses;*/
}
