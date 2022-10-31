package com.lucasalb.lcs.Controller;

import com.lucasalb.lcs.Dto.dtoProjecto;
import com.lucasalb.lcs.Entity.Projecto;
import com.lucasalb.lcs.Security.Controller.Mensaje;
import com.lucasalb.lcs.Service.SProjecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProjecto {

    @Autowired
    SProjecto sProjecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Projecto>> list() {
        List<Projecto> list = sProjecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<Projecto> getById(@PathVariable("id") int id) {
        if (!sProjecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        Projecto projecto = sProjecto.getOne(id).get();
        return new ResponseEntity(projecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProjecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        sProjecto.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProjecto dtoProj) {
        if (StringUtils.isBlank(dtoProj.getNombrePro())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProjecto.existsByNombrePro(dtoProj.getNombrePro())) {
            return new ResponseEntity(new Mensaje("Ese projecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Projecto projecto = new Projecto(dtoProj.getNombrePro(), dtoProj.getImgPro(), dtoProj.getUrlPro());
        sProjecto.save(projecto);

        return new ResponseEntity(new Mensaje("Projecto agregado"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody dtoProjecto dtoProj) {
        if (!sProjecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (sProjecto.existsByNombrePro(dtoProj.getNombrePro()) && sProjecto.getByNombrePro(dtoProj.getNombrePro()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese projecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProj.getNombrePro())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Projecto projecto = sProjecto.getOne(id).get();
        projecto.setNombrePro(dtoProj.getNombrePro());
        projecto.setImgPro(dtoProj.getImgPro());
        projecto.setUrlPro(dtoProj.getUrlPro());

        sProjecto.save(projecto);
        return new ResponseEntity(new Mensaje("Projecto editado"), HttpStatus.OK);
    }
}
