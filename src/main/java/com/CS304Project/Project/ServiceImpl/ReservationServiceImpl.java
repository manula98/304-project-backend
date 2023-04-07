package com.CS304Project.Project.ServiceImpl;

import com.CS304Project.Project.DTO.ReservationDTO;
import com.CS304Project.Project.Entity.Reservation;
import com.CS304Project.Project.Repository.ReservationRepository;
import com.CS304Project.Project.Service.ReservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
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
}
