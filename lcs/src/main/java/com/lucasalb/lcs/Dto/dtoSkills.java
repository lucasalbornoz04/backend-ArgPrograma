package com.lucasalb.lcs.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkills {
    
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String urlSkill;
    
    //Constructor

    public dtoSkills() {
    }

    public dtoSkills(String nombreSkill, String urlSkill) {
        this.nombreSkill = nombreSkill;
        this.urlSkill = urlSkill;
    }
    
    
    //Getter and Setter

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
