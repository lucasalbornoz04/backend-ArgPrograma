package com.lucasalb.lcs.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String fechaEdu;
    
    //Constructor

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String fechaEdu) {
        this.nombreEdu = nombreEdu;
        this.fechaEdu = fechaEdu;
    }
    
    //Getter and Setter

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }
    
    
}
