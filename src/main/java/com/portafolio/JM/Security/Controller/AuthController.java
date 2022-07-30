/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Security.Controller;

import com.portafolio.JM.Security.Dto.JwtDTO;
import com.portafolio.JM.Security.Dto.LoginUsuario;
import com.portafolio.JM.Security.Dto.NuevoUsuario;
import com.portafolio.JM.Security.Entity.Rol;
import com.portafolio.JM.Security.Entity.Usuario;
import com.portafolio.JM.Security.Enums.RolNombre;
import com.portafolio.JM.Security.Service.RolService;
import com.portafolio.JM.Security.Service.UsuarioService;
import com.portafolio.JM.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author monte
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://portafolio-3dca8.web.app/")
public class AuthController {
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired AuthenticationManager authentocationManager;
    @Autowired UsuarioService usuariService;
    @Autowired RolService rolService;
    @Autowired JwtProvider  jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindigResult){
        if(bindigResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
        if(usuariService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
             return new ResponseEntity(new Mensaje("cya existe este usuario"),HttpStatus.BAD_REQUEST);
        if(usuariService.existsByEmail(nuevoUsuario.getEmail()))
             return new ResponseEntity(new Mensaje("ya existe este email"),HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolnombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolnombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuariService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario Guardado"),HttpStatus.CREATED);    
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario,BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"),HttpStatus.BAD_REQUEST);
        Authentication authentication = authentocationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt =  jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity(jwtDto,HttpStatus.OK);
   }
                
    
}
