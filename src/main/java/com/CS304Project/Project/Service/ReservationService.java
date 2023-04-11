package com.CS304Project.Project.Service;

import com.CS304Project.Project.DTO.CheckReservatioDTO;
import com.CS304Project.Project.DTO.ReservationDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface ReservationService {
    List<ReservationDTO> getAllReservation();
    ReservationDTO addReservation(ReservationDTO reservationDTO) throws NoSuchAlgorithmException;
    ReservationDTO updateReservation(ReservationDTO reservationDTO);
    ReservationDTO getReservationById(int reservationId);
    boolean deleteReservation(int reservationId);

    boolean checkResourceAvalibility(CheckReservatioDTO data);
}
