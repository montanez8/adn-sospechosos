package org.campuslands.reconocimiento_sospechosos.services.imp;

import org.campuslands.reconocimiento_sospechosos.repositories.entities.Persona;

import java.util.List;

public interface PersonaService {
     List<Persona> findAll();
     Persona findById(Long id);
     Persona save(Persona persona);
     void deleteById(Long id);
     Persona findSospechoso(String muestraADN);

}
