/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Controller;

import com.portafolio.JM.Entity.Educacion;
import com.portafolio.JM.Interface.IPersonaService;
import com.portafolio.JM.Repository.IEducacionRepository;
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
public class EducacionController {
    @Autowired IEducacionRepository iEducacionRepository;
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("Educaciona/traer")
     public List<Educacion> getEducaciones() {
         return iEducacionRepository.findAll();
     }
     @PostMapping("Educacion/crear/{id}")
     public  String createEducacion(@RequestBody Educacion edu, @PathVariable Long id){
         edu.setPer(iPersonaService.FindPersona(id)) ;
         iEducacionRepository.save(edu);
         return "La Educacion fue creada correctamente";
     }
     
     @DeleteMapping("Educacion/borrar/{id}")
     public String borrarEducacion(@PathVariable Long id){
         iEducacionRepository.deleteById(id);
         return "La educacion fue borrada exitosamente";
     }
    
}

