/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.JM.Interface;

import com.portafolio.JM.Entity.Persona;
import java.util.List;

/**
 *
 * @author monte
 */
public interface IPersonaService {
    public List<Persona> getPersonas();
    public void savePersona(Persona per);
    public void deletePersona(Long id);
    public Persona FindPersona(Long id);
    
}
