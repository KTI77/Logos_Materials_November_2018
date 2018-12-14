package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "teachers")
public class TeacherEntity extends BaseEntity { // teacher_entity

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName; // first_name VARCHAR(45) NOT NULL

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    /*public TeacherEntity() {
    }*/

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
}
