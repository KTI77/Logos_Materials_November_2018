package ua.logos.entity;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class TeacherEntity { // teacher_entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public TeacherEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
