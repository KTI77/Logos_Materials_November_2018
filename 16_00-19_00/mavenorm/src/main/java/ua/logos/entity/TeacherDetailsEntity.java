package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "teacher_details")
public class TeacherDetailsEntity extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String hobby;

    private int experience;

    @Column(name = "technology_stack", columnDefinition = "TEXT")
    private String technologyStack;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
}
