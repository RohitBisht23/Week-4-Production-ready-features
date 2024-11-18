package com.ProductionReadyFeature.ProductionReadyFeature.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="Post_Table")
@Audited
public class PostEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
}
