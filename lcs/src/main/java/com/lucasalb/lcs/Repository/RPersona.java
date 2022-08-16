package com.lucasalb.lcs.Repository;

import com.lucasalb.lcs.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository<Persona, Integer> {
    public Optional<Persona> findByNombre(String nombreP);
    public boolean existsByNombre(String nombreP);
}
