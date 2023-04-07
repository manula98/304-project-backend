package com.CS304Project.Project.Controller;

import com.CS304Project.Project.DTO.ReservationDTO;
import com.CS304Project.Project.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/getAllReservation")
    public ResponseEntity<?> getAllReservation(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        List<ReservationDTO> reservationDTOList = reservationService.getAllReservation();

        if(!reservationDTOList.isEmpty()){
            map.put("status", 1);
            map.put("data", reservationDTOList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Reservation not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PostMapping("/addReservation")
    public ResponseEntity<?> addReservation(@RequestBody ReservationDTO reservationDTO) throws NoSuchAlgorithmException{
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        ReservationDTO reservation = reservationService.addReservation(reservationDTO);

        if(reservation != null){
            map.put("status", 1);
            map.put("data", reservation);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Reservation not added");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @PutMapping("/updateReservation")
    public ResponseEntity<?> updateReservation(ReservationDTO reservationDTO){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        ReservationDTO reservation = reservationService.updateReservation(reservationDTO);

        if(reservation != null){
            map.put("status", 1);
            map.put("data", reservation);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Reservation not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @GetMapping("/getReservationById/{reservationId}")
    public ResponseEntity<?> getReservationById(@PathVariable  int reservationId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        ReservationDTO reservationDTO = reservationService.getReservationById(reservationId);

        if(reservationDTO != null){
            map.put("status", 1);
            map.put("data", reservationDTO);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Reservation not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
    @DeleteMapping("/deleteReservation/{reservationId}")
    public ResponseEntity<?> deleteReservation(@PathVariable int reservationId){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        boolean deleted = reservationService.deleteReservation(reservationId);

        if(deleted){
            map.put("status", 1);
            map.put("data", deleted);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.clear();
            map.put("status", 0);
            map.put("message", "Reservation not found");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
