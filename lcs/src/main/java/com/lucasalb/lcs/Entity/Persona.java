package com.lucasalb.lcs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con los requistos")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con los requistos")
    private String apellido;
    @NotNull
    @Size(min = 1, max = 120, message = "No cumple con los requistos")
    private String titulo;
    @NotNull
    @Size(min = 1, max = 200, message = "No cumple con los requistos")
    private String urlImg;
    @NotNull
    @Size(min = 1, max = 500, message = "No cumple con los requistos")
    private String descripcion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String urlImg, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.urlImg = urlImg;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
}
