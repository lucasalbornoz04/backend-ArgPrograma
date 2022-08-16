package com.lucasalb.lcs.Service;

import com.lucasalb.lcs.Entity.Projecto;
import com.lucasalb.lcs.Repository.RProjecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProjecto {

    @Autowired
    RProjecto rProjecto;

    public List<Projecto> list() {
        return rProjecto.findAll();
    }

    public Optional<Projecto> getOne(int id) {
        return rProjecto.findById(id);
    }

    public Optional<Projecto> getByNombrePro(String nombrePro) {
        return rProjecto.findByNombrePro(nombrePro);
    }

    public void save(Projecto proj) {
        rProjecto.save(proj);
    }

    public void delete(int id) {
        rProjecto.deleteById(id);
    }

    public boolean existsById(int id) {
        return rProjecto.existsById(id);
    }

    public boolean existsByNombrePro(String nombrePro) {
        return rProjecto.existsByNombrePro(nombrePro);
    }
}
