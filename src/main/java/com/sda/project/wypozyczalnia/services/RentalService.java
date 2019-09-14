package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.RentalRepository;
import com.sda.project.wypozyczalnia.model.Rental;
import com.sda.project.wypozyczalnia.model.User;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RentalService {

    private RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental addNewRental(Rental rental) {
        return rentalRepository.save(createNewRental(rental));
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Rental.class.getName()));
            }

    public List<Rental> getRentalByName(String name) {
        return rentalRepository.findByName(name);
    }

    public List<Rental> getAllRental() {
        return Lists.newArrayList(rentalRepository.findAll());
    }

    public Rental deleteRentalById (Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Rental.class.getName()));

        rentalRepository.deleteById(id);
        return rental;
    }

    public Rental updateRentalById(Long id, Rental rental) {
        Rental foundRental = rentalRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Rental.class.getName()));

        foundRental.setName(rental.getName());
        foundRental.setDomain(rental.getDomain());
        foundRental.setContactAddress(rental.getContactAddress());
        foundRental.setOwner(rental.getOwner());
        foundRental.setLogo(rental.getLogo());

        return rentalRepository.save(foundRental);
    }

    private Rental createNewRental(Rental rental) {

        Rental result = new Rental();
        result.setName(rental.getName());
        result.setDomain(rental.getDomain());
        result.setContactAddress(rental.getContactAddress());
        result.setOwner(rental.getOwner());
        result.setLogo(rental.getLogo());

        return result;
    }
}


