package com.lucasalb.lcs.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProjecto {
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String imgPro;
    
    //Constructor

    public dtoProjecto() {
    }

    public dtoProjecto(String nombrePro, String imgPro) {
        this.nombrePro = nombrePro;
        this.imgPro = imgPro;
    }
    
    //Getter and Setter

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
    
}
