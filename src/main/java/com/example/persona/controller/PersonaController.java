package com.example.persona.controller;


import com.example.persona.entity.Persona;
import com.example.persona.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private Repository repository;


    @GetMapping("/persone")
    public List<Persona> getAllPersone() {
        return repository.findAll();
    }

    @GetMapping("/persone/{id}")
    public Persona getPersonaById(@PathVariable Long id){

        return repository.findAllById(id);
    }

    @PostMapping("/persone")
    public Persona creaPersona( @RequestBody Persona persona) {
        return repository.save(persona);
    }

    @DeleteMapping("/persone/{id}")
    public void creaPersona( @PathVariable Long id) {
        Persona persona = repository.findAllById(id);
        repository.delete(persona);
    }

    @PutMapping("/persone/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable(value = "id") Long id, @RequestBody Persona dettagliPersona){
        Persona persona = repository.findAllById(id);

        persona.setEmail(dettagliPersona.getEmail());
        persona.setNome(dettagliPersona.getNome());
        persona.setCognome(dettagliPersona.getCognome());
        final Persona updatedPersona = repository.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }
}
