/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucasalb.lcs.Controller;

import com.lucasalb.lcs.Dto.dtoPersona;
import com.lucasalb.lcs.Entity.Persona;
import com.lucasalb.lcs.Security.Controller.Mensaje;
import com.lucasalb.lcs.Service.SPersona;
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
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class CPersona {

    @Autowired
    SPersona sPersona;

    @GetMapping("/list")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPersona(@RequestBody dtoPersona dtoPer) {
        if (StringUtils.isBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sPersona.existsByNombre(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtoPer.getNombre(), dtoPer.getApellido(), dtoPer.getTitulo(), dtoPer.getDescripcion(), dtoPer.getUrlImg());
        sPersona.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregada!"), HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable Integer id) {
        sPersona.delete(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> editPersona(@PathVariable Integer id, @RequestBody dtoPersona dtoPer) {
        //validamos ID
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //compara nombres de experiencias
        if (sPersona.existsByNombre(dtoPer.getNombre()) && sPersona.getByNombre(dtoPer.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        // no puede estar vacio
        if (StringUtils.isBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = sPersona.getOne(id).get();
        persona.setNombre(dtoPer.getNombre());
        persona.setApellido(dtoPer.getApellido());
        persona.setTitulo(dtoPer.getTitulo());
        persona.setDescripcion(dtoPer.getDescripcion());
        persona.setUrlImg(dtoPer.getUrlImg());

        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizado"), HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

}
