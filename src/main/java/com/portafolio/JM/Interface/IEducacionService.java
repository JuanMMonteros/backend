/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.JM.Interface;

import com.portafolio.JM.Entity.Educacion;
import java.util.List;

/**
 *
 * @author monte
 */
public interface IEducacionService {
     public List<Educacion> getEducaciones();
    public void saveEducacion(Educacion edu);
    public void deleteEducacion(Long id);
    public Educacion FindEducacion(Long id);
    
}