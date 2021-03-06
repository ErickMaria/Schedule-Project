package com.app.agenda.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_telefone")
@JsonIgnoreProperties(value = { "contact" })
public class Telephone implements Serializable {
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long phoneNumber;

    @ManyToOne
    @JoinColumn(name = "owner",  nullable = false)
    private Contact owner;

    public Telephone(){
        
    }

    public Telephone(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact getContact() {
        return this.owner;
    }

    public void setContact(Contact contact) {
        this.owner = contact;
    }

}