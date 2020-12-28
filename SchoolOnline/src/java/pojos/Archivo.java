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
    
    private File archivo;
    
    private Integer MaterialApoyo_idMaterialApoyo;
    
    private Integer Actividad_idActividad;

    public Archivo() {
    }

    public Archivo(Integer idArchivo, File archivo, Integer MaterialApoyo_idMaterialApoyo, Integer Actividad_idActividad) {
        this.idArchivo = idArchivo;
        this.archivo = archivo;
        this.MaterialApoyo_idMaterialApoyo = MaterialApoyo_idMaterialApoyo;
        this.Actividad_idActividad = Actividad_idActividad;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public Integer getMaterialApoyo_idMaterialApoyo() {
        return MaterialApoyo_idMaterialApoyo;
    }

    public void setMaterialApoyo_idMaterialApoyo(Integer MaterialApoyo_idMaterialApoyo) {
        this.MaterialApoyo_idMaterialApoyo = MaterialApoyo_idMaterialApoyo;
    }

    public Integer getActividad_idActividad() {
        return Actividad_idActividad;
    }

    public void setActividad_idActividad(Integer Actividad_idActividad) {
        this.Actividad_idActividad = Actividad_idActividad;
    }
}
