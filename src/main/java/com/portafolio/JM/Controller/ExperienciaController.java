/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Controller;

import com.portafolio.JM.Entity.Experiencia;
import com.portafolio.JM.Interface.IPersonaService;
import com.portafolio.JM.Repository.IExperienciaRepository;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired IExperienciaRepository iExperienciaRepository;
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("Experiencia/traer")
     public List<Experiencia> getExperiencias() {
         return iExperienciaRepository.findAll();
     }
     @PostMapping("Experiencia/crear/{id}")
     public  String createExperiencia(@RequestBody Experiencia exp, @PathVariable Long id){
         exp.setPer(iPersonaService.FindPersona(id)) ;
         iExperienciaRepository.save(exp);
         return "La Experiencia fue creada correctamente";
     }
     @DeleteMapping("Experiencia/borrar/{id}")
     public String borrarEducacion(@PathVariable Long id){
         iExperienciaRepository.deleteById(id);
         return "la Experiencia due borrada exitosamente";
     }
    
}
