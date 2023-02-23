package com.CS304Project.Project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationId")
    private int reservationId;
    @Column(name = "date")
    private String date;
    @Column(name = "fromTime")
    private String fromTime;
    @Column(name = "toTime")
    private String toTime;
    @Column(name = "note")
    private String note;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "resourceId", referencedColumnName = "resourceId")
    private Resource resource;
}
