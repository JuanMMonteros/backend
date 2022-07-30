/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Controller;

import com.portafolio.JM.Entity.Proyectos;
import com.portafolio.JM.Interface.IPersonaService;
import com.portafolio.JM.Repository.IProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author monte
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    @Autowired IProyectosRepository iProyectosRepository;
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("Proyectos/traer")
     public List<Proyectos> getProyectosl() {
         return iProyectosRepository.findAll();
     }
    
     @PostMapping("Proyectos/crear/{id}")
     public  String createProyectos(@RequestBody Proyectos pro, @PathVariable Long id){
         pro.setPer(iPersonaService.FindPersona(id)) ;
         iProyectosRepository.save(pro);
         return "El Proyecto fue creada correctamente";
     }

     @DeleteMapping("Proyectos/borrar/{id}")
    public String borrarProyecto(@PathVariable Long id){
        iProyectosRepository.deleteById(id);
        return "se borro correctamente";
    }
}