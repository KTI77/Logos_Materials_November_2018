package ua.logos.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_deleted", columnDefinition = "BOOLEAN default FALSE")
    private boolean isDeleted;

}
