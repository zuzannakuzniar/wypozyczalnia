package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.AddressRepository;
import com.sda.project.wypozyczalnia.model.Address;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addNewAddress(Address address){
        return addressRepository.save(createNewAddress(address));
    }



    public List<Address> getAllAddresses(){
        return Lists.newArrayList(addressRepository.findAll());
    }

    public List<Address> findByCity(String city) {
        return addressRepository.findByCity(city);
    }

    public Address getOneAddressById(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Address.class.getName()));
    }

    public Address updateAddressById(Long id, Address address){
        Address address1 = addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Address.class.getName()));
        address1.setCity(address.getCity());
        address1.setStreet(address.getStreet());

        return address1;
    }
    public Address deleteAddressById (Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Address.class.getName()));

        addressRepository.deleteById(id);
        return address;
    }

    private Address createNewAddress(Address address) {
        Address result = new Address();
        result.setCity(address.getCity());
        result.setStreet(address.getStreet());

        return result;
    }
}
