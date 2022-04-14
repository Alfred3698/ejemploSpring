/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Persona;

/**
 *
 * @author jajimenez
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public String testMe() {
        return "hola mundo";
    }

    public Iterable<Persona> personas() {
        return personaRepository.findAll();
    }

    public Persona guardarPersona(Persona persona) {

        return personaRepository.save(persona);
    }

}
