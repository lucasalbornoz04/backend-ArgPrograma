package com.lucasalb.lcs.Service;

import com.lucasalb.lcs.Entity.Persona;
import com.lucasalb.lcs.Repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {
    @Autowired
    RPersona rPersona;
    
    public List<Persona> list(){
        return rPersona.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombreP){
        return rPersona.findByNombre(nombreP);
    }
    
    public void save(Persona per){
        rPersona.save(per);
    }
    
    public void delete(int id){
        rPersona.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public  boolean existsByNombre(String nombreP){
        return rPersona.existsByNombre(nombreP);
    }    
}
