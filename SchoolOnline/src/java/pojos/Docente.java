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
public class Docente {
    
    private Integer idDocente;
    
    private String nombre;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String gradoAcademico;
    
    private String telefono;
    
    private String Cuenta_nombreUsuario;
    
    private Integer Genero_idGenero;

    public Docente() {
    }

    public Docente(Integer idDocente, String nombre, String apellidoPaterno, String apellidoMaterno, String gradoAcademico, String telefono, String Cuenta_nombreUsuario, Integer Genero_idGenero) {
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.gradoAcademico = gradoAcademico;
        this.telefono = telefono;
        this.Cuenta_nombreUsuario = Cuenta_nombreUsuario;
        this.Genero_idGenero = Genero_idGenero;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCuenta_nombreUsuario() {
        return Cuenta_nombreUsuario;
    }

    public void setCuenta_nombreUsuario(String Cuenta_nombreUsuario) {
        this.Cuenta_nombreUsuario = Cuenta_nombreUsuario;
    }

    public Integer getGenero_idGenero() {
        return Genero_idGenero;
    }

    public void setGenero_idGenero(Integer Genero_idGenero) {
        this.Genero_idGenero = Genero_idGenero;
    }

   
}
