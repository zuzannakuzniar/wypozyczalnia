package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.ReservationRepository;
import com.sda.project.wypozyczalnia.model.Reservation;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addNewReservation(Reservation reservation) {
        return reservationRepository.save(createNewReservation(reservation));
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Reservation.class.getName()));
            }

    public List<Reservation> getAllReservation() {
        return Lists.newArrayList(reservationRepository.findAll());
    }

    public Reservation deleteReservationById (Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Reservation.class.getName()));

        reservationRepository.deleteById(id);
        return reservation;
    }

    public Reservation updateReservationById(Long id, Reservation reservation) {
        Reservation foundReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Reservation.class.getName()));

        foundReservation.setStartReservation(reservation.getStartReservation());
        foundReservation.setEndReservation(reservation.getEndReservation());
        foundReservation.setDepartmentRent(reservation.getDepartmentRent());
        foundReservation.setDepartmentReturn(reservation.getDepartmentReturn());
        foundReservation.setPrice(reservation.getPrice());

        return reservationRepository.save(foundReservation);
    }

    private Reservation createNewReservation(Reservation reservation) {

        Reservation result = new Reservation();
        result.setStartReservation(reservation.getStartReservation());
        result.setEndReservation(reservation.getEndReservation());
        result.setDepartmentRent(reservation.getDepartmentRent());
        result.setDepartmentReturn(reservation.getDepartmentReturn());
        result.setPrice(reservation.getPrice());

        return reservation;
    }
}


