/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.File;

/**
 *
 * @author javie
 */
public class Archivo {
    
    private Integer idArchivo;
    
    private String archivo;
    
    private Integer Actividad_idActividad;

    public Archivo() {
    }

    public Archivo(Integer idArchivo, String archivo, Integer Actividad_idActividad) {
        this.idArchivo = idArchivo;
        this.archivo = archivo;
        this.Actividad_idActividad = Actividad_idActividad;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Integer getActividad_idActividad() {
        return Actividad_idActividad;
    }

    public void setActividad_idActividad(Integer Actividad_idActividad) {
        this.Actividad_idActividad = Actividad_idActividad;
    }

    
}
