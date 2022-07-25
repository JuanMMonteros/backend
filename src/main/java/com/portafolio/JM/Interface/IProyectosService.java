/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.JM.Interface;

import com.portafolio.JM.Entity.Proyectos;
import java.util.List;

/**
 *
 * @author monte
 */
public interface IProyectosService {
     public List<Proyectos> getProyectos();
    public void saveProyectos(Proyectos pro);
    public void deleteProyectos(Long id);
    public Proyectos FindProyectos(Long id);
    
}
