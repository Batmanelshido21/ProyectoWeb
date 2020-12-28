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
public class GradoAcademico {
    
    private Integer idGradoAcademico;
    
    private String gradoAcademico;
    
    private String nivel;

    public GradoAcademico() {
    }

    public GradoAcademico(Integer idGradoAcademico, String gradoAcademico, String nivel) {
        this.idGradoAcademico = idGradoAcademico;
        this.gradoAcademico = gradoAcademico;
        this.nivel = nivel;
    }

    public Integer getIdGradoAcademico() {
        return idGradoAcademico;
    }

    public void setIdGradoAcademico(Integer idGradoAcademico) {
        this.idGradoAcademico = idGradoAcademico;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    } 
}
