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
public class Mensaje {
    
    private Integer idMensaje;
    
    private String mensaje;
    
    private Integer Foro_idForo;
    
    private String Alumno_clave;
    
    private String Docente_clave;

    public Mensaje() {
    }

    public Mensaje(Integer idMensaje, String mensaje, Integer Foro_idForo, String Alumno_clave, String Docente_clave) {
        this.idMensaje = idMensaje;
        this.mensaje = mensaje;
        this.Foro_idForo = Foro_idForo;
        this.Alumno_clave = Alumno_clave;
        this.Docente_clave = Docente_clave;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getForo_idForo() {
        return Foro_idForo;
    }

    public void setForo_idForo(Integer Foro_idForo) {
        this.Foro_idForo = Foro_idForo;
    }

    public String getAlumno_clave() {
        return Alumno_clave;
    }

    public void setAlumno_clave(String Alumno_clave) {
        this.Alumno_clave = Alumno_clave;
    }

    public String getDocente_clave() {
        return Docente_clave;
    }

    public void setDocente_clave(String Docente_clave) {
        this.Docente_clave = Docente_clave;
    } 
}
