/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jajimenez
 */
@RestController
@RequestMapping("persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping()
    public ResponseEntity<Iterable<Persona>> personas() {
        return new ResponseEntity<>(personaService.personas(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> guardarPersona(@RequestBody PersonaDTO personaDTO) {

        try {
            personaService.guardarPersona(new Persona(personaDTO));
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<String> actualizarPersona(@PathVariable Integer id, @RequestBody PersonaDTO personaDTO) {
        try {
            personaService.guardarPersona(new Persona(personaDTO));
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
