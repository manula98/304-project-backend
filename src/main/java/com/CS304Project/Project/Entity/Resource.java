package com.CS304Project.Project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.REMOVE)
    private List<ResourceFacility> resourceFacilities;

}