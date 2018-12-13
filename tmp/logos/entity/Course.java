package ua.logos.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(columnDefinition = "decimal(5,2) default 0", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
