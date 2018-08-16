package com.app.agenda.repository;

import com.app.agenda.entity.Email;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

    
}