package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Resource")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resource {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "resourceId")
    private int resourceId;

    @Column(name = "resourceName")
    private String resourceName;

    @Column(name = "description")
    private String description;

    @Column(name = "available")
    private boolean available;

    @Column(name = "access")
    private int access;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.REMOVE)
    private List<Multimedia> multimedia;
}
