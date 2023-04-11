package com.CS304Project.Project.Repository;

import com.CS304Project.Project.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Reservation r set r.date = ?1, r.startTime = ?2, r.endTime = ?3, r.note = ?4, r.reservationId = ?5", nativeQuery = true)
    Reservation updateReservation(String date, String startTime, String endTime, String note, int reservationId);

    @Query(value = "SELECT * FROM resource_allocation.reservation WHERE reservation_id = ?1 LIMIT 1", nativeQuery = true)
    Reservation getReservationById(@Param(value = "reservationId") int reservationId);

    @Query(value = "SELECT * FROM resource_allocation.reservation WHERE resource_id = ?1 AND date=?2 ", nativeQuery = true)
    List<Reservation> checkResourceAvalibility(int resourceId, String selectedDate);
}
