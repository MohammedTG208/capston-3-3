package com.example.capstion3.Service;


import com.example.capstion3.API.APIException;
import com.example.capstion3.Model.Reservation;
import com.example.capstion3.Repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
private final ReservationRepository reservationRepository;


    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void updateReservation(Integer id, Reservation reservation) {
        Reservation reservation1 = reservationRepository.findReservationById(id);
        if (reservation1 == null) {
            throw new APIException("Reservation not found");
        }

        reservation1.setReservation_date(reservation.getReservation_date());
        reservation1.setStatus(reservation.getStatus());
   reservationRepository.save(reservation1);

    }

    public void deleteReservation(Integer id) {
        Reservation reservation1 = reservationRepository.findReservationById(id);
        if (reservation1 == null) {
            throw new APIException("Reservation not found");
        }
        reservationRepository.delete(reservation1);

    }
}
