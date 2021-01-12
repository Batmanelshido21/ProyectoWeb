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
public class Actividad {
    
    private Integer idActividad;
    
    private String nombre;
    
    private String descripcion;
    
    private Date fechaCreada;
    
    private Date fechaEntrega;
    
    private Integer calificacion;
    
    private Integer Grupo_idGrupo;
    

    public Actividad() {
    }

    public Actividad(Integer idActividad, String nombre, String descripcion, Date fechaCreada, Date fechaEntrega, Integer calificacion, Integer Grupo_idGrupo) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreada = fechaCreada;
        this.fechaEntrega = fechaEntrega;
        this.calificacion = calificacion;
        this.Grupo_idGrupo = Grupo_idGrupo;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreada() {
        return fechaCreada;
    }

    public void setFechaCreada(Date fechaCreada) {
        this.fechaCreada = fechaCreada;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getGrupo_idGrupo() {
        return Grupo_idGrupo;
    }

    public void setGrupo_idGrupo(Integer Grupo_idGrupo) {
        this.Grupo_idGrupo = Grupo_idGrupo;
    }

   
}
