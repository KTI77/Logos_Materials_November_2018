package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "courses")
public class CourseEntity extends BaseEntity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description; // description TEXT

    @Column(name = "price", columnDefinition = "DECIMAL(5,2) DEFAULT 0", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
}
