package com.lucasalb.lcs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSkill;
    private String urlSkill;

    //Constructor
    public Skills() {
    }

    public Skills(String nombreSkill, String urlSkill) {
        this.nombreSkill = nombreSkill;
        this.urlSkill = urlSkill;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getUrlSkill() {
        return urlSkill;
    }

    public void setUrlSkill(String urlSkill) {
        this.urlSkill = urlSkill;
    }

}
