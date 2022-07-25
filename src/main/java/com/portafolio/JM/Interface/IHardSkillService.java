/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.JM.Interface;

import com.portafolio.JM.Entity.HardSkill;
import java.util.List;

/**
 *
 * @author monte
 */
public interface IHardSkillService {
     public List<HardSkill> getHardSkill();
    public void saveHardSkill(HardSkill hskill);
    public void deleteHardSkill(Long id);
    public HardSkill FindHardSkill(Long id);
    
}
