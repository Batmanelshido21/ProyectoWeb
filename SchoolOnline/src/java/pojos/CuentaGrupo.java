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
public class CuentaGrupo {
    
    private Integer Alumno_idAlumno;
    
    private Integer Grupo_idGrupo;

    public CuentaGrupo() {
    }

    public CuentaGrupo(Integer Alumno_idAlumno, Integer Grupo_idGrupo) {
        this.Alumno_idAlumno = Alumno_idAlumno;
        this.Grupo_idGrupo = Grupo_idGrupo;
    }

    public Integer getAlumno_idAlumno() {
        return Alumno_idAlumno;
    }

    public void setAlumno_idAlumno(Integer Alumno_idAlumno) {
        this.Alumno_idAlumno = Alumno_idAlumno;
    }

    public Integer getGrupo_idGrupo() {
        return Grupo_idGrupo;
    }

    public void setGrupo_idGrupo(Integer Grupo_idGrupo) {
        this.Grupo_idGrupo = Grupo_idGrupo;
    }
}
