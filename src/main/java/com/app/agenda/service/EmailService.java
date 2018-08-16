package com.app.agenda.service;

import java.util.List;

import com.app.agenda.entity.Email;
import com.app.agenda.repository.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository  eRepository;

    public void createOrUpdate(List<Email> contact) {
        this.eRepository.saveAll(contact);
    }

    public List<Email> list() {
        return this.eRepository.findAll();
    }
    
    public void delete(Email contact) {
        this.eRepository.delete(contact);;
    }

}