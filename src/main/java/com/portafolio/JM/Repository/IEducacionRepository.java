/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.JM.Repository;

import com.portafolio.JM.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author monte
 */
public interface IEducacionRepository extends JpaRepository<Educacion,Long> {
    
}

