package com.app.agenda.service;

import java.util.List;

import com.app.agenda.entity.Adress;
import com.app.agenda.repository.AdressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    private AdressRepository  aRepository;

    public void createOrUpdate(Adress contact) {
        this.aRepository.save(contact);
    }

    public List<Adress> list() {
        return this.aRepository.findAll();
    }
    
    public void delete(Adress contact) {
        this.aRepository.delete(contact);;
    }

}