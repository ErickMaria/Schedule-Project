package com.app.agenda.repository;

import com.app.agenda.entity.Telephone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

    
}