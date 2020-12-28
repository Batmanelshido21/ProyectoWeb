/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;

/**
 *
 * @author javie
 */
public class CicloEscolar {
    
    private Integer idCicloEscolar;
    
    private Date fechaInicio;
    
    private Date fechaFinal;

    public CicloEscolar() {
    }

    public CicloEscolar(Integer idCicloEscolar, Date fechaInicio, Date fechaFinal) {
        this.idCicloEscolar = idCicloEscolar;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Integer getIdCicloEscolar() {
        return idCicloEscolar;
    }

    public void setIdCicloEscolar(Integer idCicloEscolar) {
        this.idCicloEscolar = idCicloEscolar;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }  
}
