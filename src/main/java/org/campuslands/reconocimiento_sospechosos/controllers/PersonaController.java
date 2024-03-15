package org.campuslands.reconocimiento_sospechosos.controllers;
import org.campuslands.reconocimiento_sospechosos.repositories.entities.Persona;
import org.campuslands.reconocimiento_sospechosos.services.imp.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.findAll();
        return ResponseEntity.ok(personas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }

    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        Persona savedPersona = personaService.save(persona);
        return ResponseEntity.ok(savedPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }

        persona.setNombre(personaDetails.getNombre());
        persona.setApellido(personaDetails.getApellido());
        persona.setDireccion(personaDetails.getDireccion());
        persona.setEmail(personaDetails.getEmail());
        persona.setCromosoma(personaDetails.getCromosoma());

        Persona updatedPersona = personaService.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        personaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/sospechoso")
    public ResponseEntity<Persona> findSospechoso(@RequestParam String muestraADN) {
        Persona sospechoso = personaService.findSospechoso(muestraADN);
        if (sospechoso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sospechoso);
    }
}
