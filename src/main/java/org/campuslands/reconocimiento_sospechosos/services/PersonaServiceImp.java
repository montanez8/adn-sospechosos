package org.campuslands.reconocimiento_sospechosos.services;

import lombok.AllArgsConstructor;
import org.campuslands.reconocimiento_sospechosos.repositories.entities.Persona;
import org.campuslands.reconocimiento_sospechosos.repositories.entities.PersonaRepository;
import org.campuslands.reconocimiento_sospechosos.services.imp.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonaServiceImp implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    public Persona findSospechoso(String muestraADN) {
        List<Persona> personas = personaRepository.findAll();
        int maxSimilitud = 0;
        Persona sospechoso = null;

        for (Persona persona : personas) {
            int similitud = calcularSimilitud(muestraADN, persona.getCromosoma());
            if (similitud > maxSimilitud) {
                maxSimilitud = similitud;
                sospechoso = persona;
            }
        }

        if (sospechoso != null) {
            double porcentajeParentesco = (double) maxSimilitud / muestraADN.length() * 100;
            System.out.println("Porcentaje de parentesco: " + porcentajeParentesco + "%");
        }

        return sospechoso;
    }

    private int calcularSimilitud(String muestraADN, String cromosoma) {
        int similitud = 0;
        for (int i = 0; i < muestraADN.length(); i++) {
            if (muestraADN.charAt(i) == cromosoma.charAt(i)) {
                similitud++;
            }
        }
        return similitud;
    }
}
