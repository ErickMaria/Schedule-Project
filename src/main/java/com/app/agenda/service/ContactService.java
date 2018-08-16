package com.app.agenda.service;

import java.util.List;

import com.app.agenda.entity.Contact;
import com.app.agenda.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository  cRepository;

    public void createOrUpdate(Contact contact) {
        this.cRepository.save(contact);
    }

    public List<Contact> list() {
        return this.cRepository.findAll();
    }

    public void delete(Long id) {

        Contact c =  cRepository.findById(id).get();
        this.cRepository.delete(c);
    }

}