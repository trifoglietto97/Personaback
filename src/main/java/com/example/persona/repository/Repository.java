package com.example.persona.repository;

import com.example.persona.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Persona, Long> {
    Persona findAllById(Long personaId);
}
