/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.File;
import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class Bitacora {
    
    private Integer idBitacora;
    
    private Date fecha;
    
    private String archivo;
    
    private Integer Docente_idDocente;

    public Bitacora() {
    }

    public Bitacora(Integer idBitacora, Date fecha, String archivo, Integer Docente_idDocente) {
        this.idBitacora = idBitacora;
        this.fecha = fecha;
        this.archivo = archivo;
        this.Docente_idDocente = Docente_idDocente;
    }

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Integer getDocente_idDocente() {
        return Docente_idDocente;
    }

    public void setDocente_idDocente(Integer Docente_idDocente) {
        this.Docente_idDocente = Docente_idDocente;
    }

   
}
