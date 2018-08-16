package com.app.agenda.repository;

import com.app.agenda.entity.Adress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {

    
}