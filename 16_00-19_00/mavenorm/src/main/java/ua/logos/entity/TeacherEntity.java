package ua.logos.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@ToString(callSuper = true,
        exclude = {"courses", "teacherDetails"}
        )


@Entity
@Table(name = "teachers")
public class TeacherEntity extends BaseEntity { // teacher_entity

   /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    */

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;// first_name varchar(45) not null

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @OneToMany(mappedBy = "teacher")
    private List<CourseEntity> courses;

    @OneToOne(mappedBy = "teacher", fetch = FetchType.LAZY)
    private TeacherDetailsEntity teacherDetails;

    /*
    public TeacherEntity() {
    }
    */

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    */
}
