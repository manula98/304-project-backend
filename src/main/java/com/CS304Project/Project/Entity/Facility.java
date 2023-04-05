package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;

import java.util.List;

@Entity
@Table(name = "facility")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facilityId")
    private int facilityId;
    @Column(name = "facilityType")
    private String facilityType;

    @OneToMany(mappedBy = "facility", cascade = CascadeType.MERGE)
    private List<ResourceFacility> resourceFacilities;
}
