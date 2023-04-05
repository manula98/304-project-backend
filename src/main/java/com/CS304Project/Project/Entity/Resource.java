package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="resource")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resourceId")
    private int resourceId;

    @Column(name = "resourceName")
    private String resourceName;

    @Column(name = "description")
    private String description;

    @Column(name = "staffAvalibility")
    private boolean staffAvalibility;

    @Column(name = "studentAvalibility")
    private boolean studentAvalibility;

    @Column(name = "publicAvalibility")
    private boolean publicAvalibility;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.REMOVE)
    private List<Multimedia> multimedia;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.REMOVE)
    private List<Feedback> feedbacks;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "adminId",referencedColumnName = "adminId")
    private Administrative administrative;

    @OneToMany(mappedBy = "resource",cascade = CascadeType.REMOVE)
    private List<Category> categories;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.MERGE)
    private List<ResourceFacility> resourceFacilities;

}