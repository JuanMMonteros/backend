/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Service;

import com.portafolio.JM.Entity.Persona;
import com.portafolio.JM.Interface.IPersonaService;
import com.portafolio.JM.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service
public class ImpPersonaService implements IPersonaService {
    
    @Autowired IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> personas = iPersonaRepository.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona per) {
        iPersonaRepository.save(per);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona FindPersona(Long id) {
        Persona per = iPersonaRepository.findById(id).orElse(null);
        return per;
    }
    
}
