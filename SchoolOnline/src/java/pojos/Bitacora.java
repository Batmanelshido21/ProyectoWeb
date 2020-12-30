/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.File;
import java.sql.Date;

/**
 *
 * @author javie
 */
public class Bitacora {
    
    private Integer idBitacora;
    
    private Date fecha;
    
    private byte[] archivo;
    
    private String Docente_clave;

    public Bitacora() {
    }

    public Bitacora(Integer idBitacora, Date fecha, byte[] archivo, String Docente_clave) {
        this.idBitacora = idBitacora;
        this.fecha = fecha;
        this.archivo = archivo;
        this.Docente_clave = Docente_clave;
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

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public String getDocente_clave() {
        return Docente_clave;
    }

    public void setDocente_clave(String Docente_clave) {
        this.Docente_clave = Docente_clave;
    }

    
}
