package com.app.agenda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_contact")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String profession;
    

    @OneToMany(mappedBy="owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telephone> telephones;
    
    @OneToMany(mappedBy="owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;
    
    @OneToOne(mappedBy="owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Adress adress;

    public Contact(){

    }

    public Contact(String name, String profession, List<Telephone> telephones, List<Email> emails, Adress adress) {
        this.name = name;
        this.profession = profession;
        this.telephones = telephones;
        this.emails = emails;
        this.adress = adress;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public List<Telephone> getTelephones() {
        return this.telephones;
    }

    public void setTelephone(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public List<Email> getEmails() {
        return this.emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Adress getAdress() {
        return this.adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

}