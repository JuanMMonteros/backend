/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.JM.Service;

import com.portafolio.JM.Entity.SoftSkill;
import com.portafolio.JM.Interface.ISoftSkillService;
import com.portafolio.JM.Repository.ISoftSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service
public class ImpSoftSkillService implements ISoftSkillService {
    @Autowired ISoftSkillRepository iSoftSkillRepository;

    @Override
    public List<SoftSkill> getSoftSkill() {
        return iSoftSkillRepository.findAll();
    }

    @Override
    public void saveSoftSkill(SoftSkill sSkill) {
        iSoftSkillRepository.save(sSkill);
    }

    @Override
    public void deleteSoftSkill(Long id) {
        iSoftSkillRepository.deleteById(id);
    }

    @Override
    public SoftSkill FindSoftSkill(Long id) {
        return iSoftSkillRepository.findById(id).orElse(null);
    }
    
}
