package com.portafolio.JM.Interface;
import com.portafolio.JM.Entity.Experiencia;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author monte
 */
public interface IExperienciaService {
     public List<Experiencia> getExperiencias();
    public void saveExperiencia(Experiencia exp);
    public void deleteExperiencia(Long id);
    public Experiencia FindExperiencia(Long id);
    
}
