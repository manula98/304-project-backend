package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resourceFacility")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResourceFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resourceFacilityId")
    private int resourceFacilityId;
//    @Column(name = "facilityId")
//    private int facilityId;
//    @Column(name = "resourceId")
//    private int resourceId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "resourceId", referencedColumnName = "resourceId")
    private Resource resource;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "facilityId", referencedColumnName = "facilityId")
    private Facility facility;
}
