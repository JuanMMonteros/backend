/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Service;

import com.portafolio.JM.Entity.Experiencia;
import com.portafolio.JM.Interface.IExperienciaService;
import com.portafolio.JM.Repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author monte
 */
@Service
public class ImpExperienciaService implements IExperienciaService {
    @Autowired IExperienciaRepository iExperienciaRepository;

    @Override
    public List<Experiencia> getExperiencias() {
       List<Experiencia> exp = iExperienciaRepository.findAll();
       return exp;
    }

    @Override
    public void saveExperiencia(Experiencia exp) {
        iExperienciaRepository.save(exp);
    }

    @Override
    public void deleteExperiencia(Long id) {
        iExperienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia FindExperiencia(Long id) {
        return iExperienciaRepository.findById(id).orElse(null);
    }
    
}
