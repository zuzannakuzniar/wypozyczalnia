package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
