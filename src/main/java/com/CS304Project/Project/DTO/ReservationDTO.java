package com.CS304Project.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationDTO {
    private int reservationId;
    private String date;
    private String fromTime;
    private String toTime;
    private String note;
    private int resourceId;
    private int userId;
}
