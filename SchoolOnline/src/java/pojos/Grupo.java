/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author javie
 */
public class Grupo {
    
    private Integer idGrupo;
    
    private String nombre;
    
    private Integer CicloEscolar_idCicloEscolar;
    
    private Integer Foro_idForo;
    
    private Integer Docente_idDocente;

    public Grupo() {
    }

    public Grupo(Integer idGrupo, String nombre, Integer CicloEscolar_idCicloEscolar, Integer Foro_idForo, Integer Docente_idDocente) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.CicloEscolar_idCicloEscolar = CicloEscolar_idCicloEscolar;
        this.Foro_idForo = Foro_idForo;
        this.Docente_idDocente = Docente_idDocente;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCicloEscolar_idCicloEscolar() {
        return CicloEscolar_idCicloEscolar;
    }

    public void setCicloEscolar_idCicloEscolar(Integer CicloEscolar_idCicloEscolar) {
        this.CicloEscolar_idCicloEscolar = CicloEscolar_idCicloEscolar;
    }

    public Integer getForo_idForo() {
        return Foro_idForo;
    }

    public void setForo_idForo(Integer Foro_idForo) {
        this.Foro_idForo = Foro_idForo;
    }

    public Integer getDocente_idDocente() {
        return Docente_idDocente;
    }

    public void setDocente_idDocente(Integer Docente_idDocente) {
        this.Docente_idDocente = Docente_idDocente;
    }

   
}
