/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Service;

import com.portafolio.JM.Entity.HardSkill;
import com.portafolio.JM.Interface.IHardSkillService;
import com.portafolio.JM.Repository.IHardSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service
public class ImpHardSkillService implements IHardSkillService{
    @Autowired IHardSkillRepository iHardSkillRepository;

    @Override
    public List<HardSkill> getHardSkill() {
     return iHardSkillRepository.findAll();
    }

    @Override
    public void saveHardSkill(HardSkill hskill) {
        iHardSkillRepository.save(hskill);
    }

    @Override
    public void deleteHardSkill(Long id) {
        iHardSkillRepository.deleteById(id);
    }

    @Override
    public HardSkill FindHardSkill(Long id) {
        return iHardSkillRepository.findById(id).orElse(null);

    }
    
}
