package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "multimedia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "multimediaId")
    private int multimediaId;
    @Column(name = "multimediaPath")
    private String multimeadiaPath;
    @Column(name = "alternativeText")
    private String alternativeText;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "resourceId", referencedColumnName = "resourceId")
    private Resource resource;
}
