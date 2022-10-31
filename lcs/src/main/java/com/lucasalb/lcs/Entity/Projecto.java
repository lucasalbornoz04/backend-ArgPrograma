package com.lucasalb.lcs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrePro;
    private String imgPro;
    private String urlPro;

    //Constructor
    public Projecto() {
    }

    public Projecto(String nombrePro, String imgPro, String urlPro) {
        this.nombrePro = nombrePro;
        this.imgPro = imgPro;
        this.urlPro = urlPro;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getImgPro() {
        return imgPro;
    }

    public void setImgPro(String imgPro) {
        this.imgPro = imgPro;
    }
    public String getUrlPro() {
        return urlPro;
    }
    
    public void setUrlPro(String urlPro){
        this.urlPro = urlPro;
    }

}
