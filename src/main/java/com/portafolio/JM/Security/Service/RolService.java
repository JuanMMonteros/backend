/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Security.Service;

import com.portafolio.JM.Security.Entity.Rol;
import com.portafolio.JM.Security.Enums.RolNombre;
import com.portafolio.JM.Security.Repository.IRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author monte
 */
@Service
@Transactional
public class RolService {
    @Autowired IRolRepository iRolRepository;
    public Optional<Rol> getByRolnombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
        
    }
    
}
