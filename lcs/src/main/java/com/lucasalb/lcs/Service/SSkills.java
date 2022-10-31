package com.lucasalb.lcs.Service;

import com.lucasalb.lcs.Entity.Skills;
import com.lucasalb.lcs.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {

    @Autowired
    RSkills rSkills;

    public List<Skills> list() {
        return rSkills.findAll();
    }

    public Optional<Skills> getOne(int id) {
        return rSkills.findById(id);
    }

    public Optional<Skills> getByNombre(String nombreSkill) {
        return rSkills.findByNombreSkill(nombreSkill);
    }

    public void save(Skills skill) {
        rSkills.save(skill);
    }

    public void delete(int id) {
        rSkills.deleteById(id);
    }

    public boolean existsById(int id) {
        return rSkills.existsById(id);
    }

    public boolean existsByNombre(String nombreSkill) {
        return rSkills.existsByNombreSkill(nombreSkill);
    }
}
