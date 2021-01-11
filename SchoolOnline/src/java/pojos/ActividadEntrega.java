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
public class ActividadEntrega {
    
    private Integer idActividadEntrega;
    
    private String archivo;
    
    private String nombre;
    
    private Integer Actividad_idActividad;
    
    private Integer Alumno_idAlumno;
    
    private int calificacion;

    public ActividadEntrega() {
    }

    public ActividadEntrega(Integer idActividadEntrega, String archivo, String nombre, Integer Actividad_idActividad, Integer Alumno_idAlumno, int calificacion) {
        this.idActividadEntrega = idActividadEntrega;
        this.archivo = archivo;
        this.nombre = nombre;
        this.Actividad_idActividad = Actividad_idActividad;
        this.Alumno_idAlumno = Alumno_idAlumno;
        this.calificacion = calificacion;
    }

    public Integer getIdActividadEntrega() {
        return idActividadEntrega;
    }

    public void setIdActividadEntrega(Integer idActividadEntrega) {
        this.idActividadEntrega = idActividadEntrega;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getActividad_idActividad() {
        return Actividad_idActividad;
    }

    public void setActividad_idActividad(Integer Actividad_idActividad) {
        this.Actividad_idActividad = Actividad_idActividad;
    }

    public Integer getAlumno_idAlumno() {
        return Alumno_idAlumno;
    }

    public void setAlumno_idAlumno(Integer Alumno_idAlumno) {
        this.Alumno_idAlumno = Alumno_idAlumno;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
      
}
