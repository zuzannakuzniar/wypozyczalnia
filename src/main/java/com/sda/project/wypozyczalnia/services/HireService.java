package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.EquipmentRepository;
import com.sda.project.wypozyczalnia.dao.HireRepository;
import com.sda.project.wypozyczalnia.model.Equipment;
import com.sda.project.wypozyczalnia.model.Hire;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HireService {

    private HireRepository hireRepository;

    public HireService(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }

    public Hire addNewHire(Hire hire) {
        return hireRepository.save(createNewHire(hire));
    }


    public List<Hire> getAllHires(){
        return Lists.newArrayList(hireRepository.findAll());
    }

    public Hire getOneHireById(Long id){
        return hireRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Hire.class.getName()));
    }

    public Hire updateHireById(Long id, Hire hire){
        Hire hire1 = hireRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Hire.class.getName()));
        hire1.setEmployee(hire.getEmployee());
        hire1.setDate(hire.getDate());
        hire1.setReservation(hire.getReservation());
        hire1.setComments(hire.getComments());
        return hire1;

    }
    public Hire deleteHireById (Long id) {
        Hire hire = hireRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Hire.class.getName()));

        hireRepository.deleteById(id);
        return hire;
    }

    private Hire createNewHire(Hire hire) {
        Hire result = new Hire();
        result.setEmployee(hire.getEmployee());
        result.setDate(hire.getDate());
        result.setReservation(hire.getReservation());
        result.setComments(hire.getComments());
        return result;
    }
}


