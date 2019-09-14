package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.ReturnCarRepository;
import com.sda.project.wypozyczalnia.model.ReturnCar;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReturnCarService {

    private ReturnCarRepository returnCarRepository;

    public ReturnCarService(ReturnCarRepository returnCarRepository) {
        this.returnCarRepository = returnCarRepository;
    }

    public ReturnCar addNewReturnCar(ReturnCar returnCar) {
        return returnCarRepository.save(createNewReturnCar(returnCar));
    }

    public ReturnCar getReturnCarById(Long id) {
        return returnCarRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, ReturnCar.class.getName()));
            }

    public List<ReturnCar> getAllReturnCar() {
        return Lists.newArrayList(returnCarRepository.findAll());
    }

    public ReturnCar deleteReturnCarById (Long id) {
        ReturnCar returnCar = returnCarRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, ReturnCar.class.getName()));

        returnCarRepository.deleteById(id);
        return returnCar;
    }

    public ReturnCar updateReturnCarById(Long id, ReturnCar returnCar) {
        ReturnCar foundReturnCar = returnCarRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, ReturnCar.class.getName()));

        foundReturnCar.setReturnDate(returnCar.getReturnDate());
        foundReturnCar.setSupplement(returnCar.getSupplement());
        foundReturnCar.setComments(returnCar.getComments());

        return returnCarRepository.save(foundReturnCar);
    }

    private ReturnCar createNewReturnCar(ReturnCar returnCar) {

        ReturnCar result = new ReturnCar();
        result.setReturnDate(returnCar.getReturnDate());
        result.setSupplement(returnCar.getSupplement());
        result.setComments(returnCar.getComments());

        return returnCar;
    }
}


