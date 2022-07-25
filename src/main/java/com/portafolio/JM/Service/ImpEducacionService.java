/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Service;

import com.portafolio.JM.Entity.Educacion;
import com.portafolio.JM.Interface.IEducacionService;
import com.portafolio.JM.Repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service
public class ImpEducacionService implements IEducacionService {
    @Autowired IEducacionRepository iEducacionRepository;

    @Override
    public List<Educacion> getEducaciones() {
        return iEducacionRepository.findAll();
    }

    @Override
    public void saveEducacion(Educacion edu) {
        iEducacionRepository.save(edu);
    }

    @Override
    public void deleteEducacion(Long id) {
        iEducacionRepository.deleteById(id);
    }

    @Override
    public Educacion FindEducacion(Long id) {
        return iEducacionRepository.findById(id).orElse(null);
    }
    
}
