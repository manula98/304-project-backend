package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.CheckReservatioDTO;
import com.CS304Project.Project.DTO.ReservationDTO;
import com.CS304Project.Project.Entity.Reservation;
import com.CS304Project.Project.Repository.ReservationRepository;
import com.CS304Project.Project.Service.ReservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReservationDTO> getAllReservation() {
        try{
            List<Reservation> reservations = reservationRepository.findAll();

            if(reservations == null){
                return null;

            }else{
                return modelMapper.map(reservations, new TypeToken<List<ReservationDTO>>(){}.getType());
            }

        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public ReservationDTO addReservation(ReservationDTO reservationDTO) throws NoSuchAlgorithmException {
        try{
            Reservation reservation = modelMapper.map(reservationDTO, Reservation.class);
            Reservation addReservation = reservationRepository.save(reservation);
            return modelMapper.map(addReservation, new TypeToken<ReservationDTO>(){}.getType());
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public ReservationDTO updateReservation(ReservationDTO reservationDTO) {
        try{
            ReservationDTO validReservation = getReservationById(reservationDTO.getReservationId());
            if(validReservation != null){
                Reservation reservation = reservationRepository.updateReservation(reservationDTO.getDate(), reservationDTO.getDate(), reservationDTO.getStartTime(), reservationDTO.getEndTime(), reservationDTO.getReservationId());

                return modelMapper.map(reservation, new TypeToken<ReservationDTO>(){}.getType());

            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public ReservationDTO getReservationById(int reservationId) {
        try{
            Reservation reservation = reservationRepository.getReservationById(reservationId);

            if(reservation != null){
                return modelMapper.map(reservation, new TypeToken<ReservationDTO>(){}.getType());
            }else{
                return null;
            }

        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteReservation(int reservationId) {
        boolean delete = false;
        try{
            ReservationDTO reservationDTO = getReservationById(reservationId);

            if(reservationDTO != null){
                reservationRepository.deleteById(reservationId);
                delete = true;
            }
            return delete;
        }catch (Exception e){
            System.out.println(e.toString());
            return delete;
        }
    }

    @Override
    public boolean checkResourceAvalibility(CheckReservatioDTO data) {
        try{
            List<Reservation> reservationList=reservationRepository.checkResourceAvalibility(data.getResourceId(),data.getSelectedDate());
            if(reservationList!=null){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
                for(Reservation r:reservationList){
                    LocalDateTime date1 = LocalDateTime.parse(data.getSelectedDate()+" "+data.getSelectedTimeFrom()+":00", dtf);
                    LocalDateTime date2 = LocalDateTime.parse(r.getDate()+" "+r.getStartTime()+":00", dtf);

                    LocalDateTime date3 = LocalDateTime.parse(data.getSelectedDate()+" "+data.getSelectedTimeTo()+":00", dtf);
                    LocalDateTime date4 = LocalDateTime.parse(r.getDate()+" "+r.getEndTime()+":00", dtf);

                    if ((date1.isAfter(date2) && date1.isBefore(date4)) || (date3.isAfter(date2) && date3.isBefore(date4)) || (date1.isBefore(date2) && date3.isAfter(date4)) || (date1.isEqual(date2) && date3.isEqual( date4)) ) {
                        return false;
                    }
                }
            }
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
}
