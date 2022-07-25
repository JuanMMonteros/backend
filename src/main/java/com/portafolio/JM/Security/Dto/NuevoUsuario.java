/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Security.Dto;


import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author monte
 */
@Getter @Setter
public class NuevoUsuario {
@NotBlank
    private String nombre;
@NotBlank
    private String nombreUsuario;
@NotBlank
    private String email;
@NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();
    
}
