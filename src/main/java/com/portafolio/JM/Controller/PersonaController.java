/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Controller;

import com.portafolio.JM.Entity.Persona;
import com.portafolio.JM.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author monte
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService iPersonaService;
    @GetMapping("personas/traer")
     public List<Persona> getPersonas() {
         return iPersonaService.getPersonas();
     }
      @GetMapping("personas/traer/perfil")
    public Persona perfil(){
        Long idPerfil = (long)1;
        return iPersonaService.FindPersona(idPerfil);
    }

     @PostMapping("personas/crear")
     public  String createPersona(@RequestBody Persona per){
         iPersonaService.savePersona(per);
         return "La persona fue creada correctamente";
     }
     @PreAuthorize("hasRole('ADMIN')")
     @DeleteMapping("personas/borrar/{id}")
     public String deleteePersona(@PathVariable Long id){
         iPersonaService.deletePersona(id);
         return "La persona se elimino corectamente";
     }
    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("sobre_mi") String nuevosobre_mi)
            {
        Persona per = iPersonaService.FindPersona(id);
        per.setSobre_mi(nuevosobre_mi);
        iPersonaService.savePersona(per);
        return per;
    }
   
}
