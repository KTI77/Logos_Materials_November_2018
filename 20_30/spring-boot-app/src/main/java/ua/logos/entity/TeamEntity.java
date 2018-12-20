package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "teams")
public class TeamEntity extends BaseEntity {

    @Column(nullable = false, unique = true, length = 150)
    private String name;

    @Column(nullable = false, length = 150)
    private String engine;
}
