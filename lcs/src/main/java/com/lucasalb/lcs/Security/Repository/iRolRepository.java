package com.lucasalb.lcs.Security.Repository;

import com.lucasalb.lcs.Security.Entity.Rol;
import com.lucasalb.lcs.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
