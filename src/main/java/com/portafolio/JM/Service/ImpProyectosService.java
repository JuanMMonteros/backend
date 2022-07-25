/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Service;

import com.portafolio.JM.Entity.Proyectos;
import com.portafolio.JM.Interface.IProyectosService;
import com.portafolio.JM.Repository.IProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service
public class ImpProyectosService implements IProyectosService {
    @Autowired IProyectosRepository iProyectosRepository;

    @Override
    public List<Proyectos> getProyectos() {
        return iProyectosRepository.findAll();
    }

    @Override
    public void saveProyectos(Proyectos pro) {
        iProyectosRepository.save(pro);
    }

    @Override
    public void deleteProyectos(Long id) {
        iProyectosRepository.deleteById(id);
    }

    @Override
    public Proyectos FindProyectos(Long id) {
        return iProyectosRepository.findById(id).orElse(null);
    }
    
}
