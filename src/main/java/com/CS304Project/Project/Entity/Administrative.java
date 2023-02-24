package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "administrative")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Administrative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminID")
    private int adminId;
    @Column(name = "email")
    private String email;
    @Column(name = "contactPerson")
    private String contactPerson;
    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "administrative", cascade = CascadeType.MERGE)
    private List<Resource> resources;
}
