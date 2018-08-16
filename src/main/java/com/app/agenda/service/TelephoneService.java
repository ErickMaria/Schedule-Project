package com.app.agenda.service;

import java.util.List;

import com.app.agenda.entity.Telephone;
import com.app.agenda.repository.TelephoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelephoneService {

    @Autowired
    private TelephoneRepository  tRepository;

    public void createOrUpdate(List<Telephone> contact) {
        this.tRepository.saveAll(contact);
    }

    public List<Telephone> list() {
        return this.tRepository.findAll();
    }
    
    public void delete(Telephone contact) {
        this.tRepository.delete(contact);
    }

}