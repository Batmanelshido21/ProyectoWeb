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
public class Materia {
    
    private Integer idMateria;
    
    private String nombre;
    
    private String descripcion;
    
    private Integer GradoAcademico_idGradoAcademico;

    public Materia() {
    }

    public Materia(Integer idMateria, String nombre, String descripcion, Integer GradoAcademico_idGradoAcademico) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.GradoAcademico_idGradoAcademico = GradoAcademico_idGradoAcademico;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
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

    public Integer getGradoAcademico_idGradoAcademico() {
        return GradoAcademico_idGradoAcademico;
    }

    public void setGradoAcademico_idGradoAcademico(Integer GradoAcademico_idGradoAcademico) {
        this.GradoAcademico_idGradoAcademico = GradoAcademico_idGradoAcademico;
    }
}
