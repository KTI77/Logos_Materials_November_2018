package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = "teacher")

@Entity
@Table(name = "teacher_details")
public class TeacherDetailsEntity extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String hobby;

    private Integer experience;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
}
