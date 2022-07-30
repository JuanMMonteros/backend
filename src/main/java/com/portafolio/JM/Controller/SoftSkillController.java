/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Controller;

import com.portafolio.JM.Entity.SoftSkill;
import com.portafolio.JM.Interface.IPersonaService;
import com.portafolio.JM.Repository.ISoftSkillRepository;
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
public class SoftSkillController {
    @Autowired ISoftSkillRepository iSoftSkillRepository;
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("SoftSkill/traer")
     public List<SoftSkill> getSoftSkill() {
         return iSoftSkillRepository.findAll();
     }
     @PostMapping("SoftSkill/crear/{id}")
     public  String createSoftSkill(@RequestBody SoftSkill sSkill, @PathVariable Long id){
         sSkill.setPer(iPersonaService.FindPersona(id)) ;
         iSoftSkillRepository.save(sSkill);
         return "La SoftSkill fue creada correctamente";
     }
     @DeleteMapping("SoftSkill/borrar/{id}")
     public String borrarSoftSkill(@PathVariable Long id){
         iSoftSkillRepository.deleteById(id);
         return "la SoftSkill fue borrada Exitosamente";
         
     }
    
}
