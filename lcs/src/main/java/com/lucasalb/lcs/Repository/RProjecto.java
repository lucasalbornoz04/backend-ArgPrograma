package com.lucasalb.lcs.Repository;

import com.lucasalb.lcs.Entity.Projecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProjecto extends JpaRepository<Projecto, Integer>{
    public Optional<Projecto> findByNombrePro(String nombrePro);
    public boolean existsByNombrePro(String nombrePro);
}
