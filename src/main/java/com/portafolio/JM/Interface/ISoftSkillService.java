/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.JM.Interface;

import com.portafolio.JM.Entity.SoftSkill;
import java.util.List;

/**
 *
 * @author monte
 */
public interface ISoftSkillService {
     public List<SoftSkill> getSoftSkill();
    public void saveSoftSkill(SoftSkill sSkill);
    public void deleteSoftSkill(Long id);
    public SoftSkill FindSoftSkill(Long id);
    
}
