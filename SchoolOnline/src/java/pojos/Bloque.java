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
public class Bloque {
    
    private Integer idBloque;
    
    private Date fechaInicio;
    
    private Date fechaTermino;
    
    private String nombre;
    
    private String propositos;
    
    private Integer Grupo_idGrupo;

    public Bloque() {
    }

    public Bloque(Integer idBloque, Date fechaInicio, Date fechaTermino, String nombre, String propositos, Integer Grupo_idGrupo) {
        this.idBloque = idBloque;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.nombre = nombre;
        this.propositos = propositos;
        this.Grupo_idGrupo = Grupo_idGrupo;
    }

    public Integer getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(Integer idBloque) {
        this.idBloque = idBloque;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropositos() {
        return propositos;
    }

    public void setPropositos(String propositos) {
        this.propositos = propositos;
    }

    public Integer getGrupo_idGrupo() {
        return Grupo_idGrupo;
    }

    public void setGrupo_idGrupo(Integer Grupo_idGrupo) {
        this.Grupo_idGrupo = Grupo_idGrupo;
    } 
}
