/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Entity;

import com.sun.istack.NotNull;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
@Table
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @NotNull
    @Column
    private String nombre;
    @NotNull
    @Column
    private String apellido;
    @Column
    private String img;
    @Column
    @NotNull
    private String profecion;
    @Column
    @NotNull
    private String sobre_mi;
    
    @OneToMany(mappedBy = "per",cascade = CascadeType.ALL)
    private List<Experiencia> exp;   
     @OneToMany(mappedBy = "per",cascade = CascadeType.ALL)
    private List<Educacion> educacion;
      @OneToMany(mappedBy = "per",cascade = CascadeType.ALL)
    private List<HardSkill> hard;
        @OneToMany(mappedBy = "per",cascade = CascadeType.ALL)
    private List<SoftSkill> soft;
       @OneToMany(mappedBy = "per",cascade = CascadeType.ALL)
    private List<Proyectos> proyectos; 
    
    
}
