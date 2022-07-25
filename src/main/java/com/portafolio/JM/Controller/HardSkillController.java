/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Controller;

import com.portafolio.JM.Entity.HardSkill;
import com.portafolio.JM.Interface.IPersonaService;
import com.portafolio.JM.Repository.IHardSkillRepository;
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
public class HardSkillController {
    @Autowired IHardSkillRepository iHardSkillRepository;
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("HardSkill/traer")
     public List<HardSkill> getHardSkill() {
         return iHardSkillRepository.findAll();
     }
     @PostMapping("HardSkill/crear/{id}")
     public  String createHardSkill(@RequestBody HardSkill hSkill, @PathVariable Long id){
         hSkill.setPer(iPersonaService.FindPersona(id)) ;
         iHardSkillRepository.save(hSkill);
         return "La HardSkill fue creada correctamente";
     }

     @DeleteMapping("HardSkill/borrar/{id}")
     public String borrarHardSkill(@PathVariable Long id){
         iHardSkillRepository.deleteById(id);
         return "la HardSkill fue borrada Exitosamente";
         
     }
    
}