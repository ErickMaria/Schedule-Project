package com.app.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.app.agenda.entity.Contact;
import com.app.agenda.entity.Email;
import com.app.agenda.entity.Telephone;
import com.app.agenda.service.AdressService;
import com.app.agenda.service.ContactService;
import com.app.agenda.service.EmailService;
import com.app.agenda.service.TelephoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private EmailService eService;
    @Autowired
    private TelephoneService tService;
    @Autowired
    private AdressService aService;
    @Autowired
    private ContactService cService;

    @RequestMapping(value="/contacts", method = RequestMethod.POST)
    public void save(@RequestBody @Valid Contact contact) {
        saveOrUpdate(contact);
    }

    @RequestMapping(value="/contacts", method = RequestMethod.GET)
    public List<Contact> list() {
        return cService.list();
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        cService.delete(id);
    }

    @RequestMapping(value="/contacts/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id, @RequestBody @Valid Contact contact) {
        saveOrUpdate(contact);
    }

    private void saveOrUpdate(Contact contact) {

        List<Telephone> telephones = new ArrayList<>();
        List<Email> emails = new ArrayList<>();
        
        contact.getTelephones().forEach(t -> {
            t.setContact(contact);
            telephones.add(t);
        });

        contact.getEmails().forEach(e -> {
            e.setContact(contact);
            emails.add(e);
        });

        contact.getAdress().setContact(contact);
    
        this.cService.createOrUpdate(contact);
        this.tService.createOrUpdate(contact.getTelephones());
        this.eService.createOrUpdate(contact.getEmails());
        this.aService.createOrUpdate(contact.getAdress());

    }
    
}