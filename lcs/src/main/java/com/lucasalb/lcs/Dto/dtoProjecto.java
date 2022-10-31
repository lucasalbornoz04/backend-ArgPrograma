package com.lucasalb.lcs.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProjecto {

    @NotBlank
    private String nombrePro;
    @NotBlank
    private String imgPro;
    @NotBlank
    private String urlPro;

    //Constructor
    public dtoProjecto() {
    }

    public dtoProjecto(String nombrePro, String imgPro, String urlPro) {
        this.nombrePro = nombrePro;
        this.imgPro = imgPro;
        this.urlPro = urlPro;
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
    
    public String getUrlPro(){
        return urlPro;
    }
    
    public void setUrlPro(String urlPro){
        this.urlPro = urlPro;
    }

}
