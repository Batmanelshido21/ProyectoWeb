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
public class Alumno {
    
    private Integer idAlumno;
    
    private String nombre;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String Cuenta_nombreUsuario;
    
    private Integer Genero_idGenero;

    public Alumno() {
    }

    public Alumno(Integer idAlumno, String nombre, String apellidoPaterno, String apellidoMaterno, String Cuenta_nombreUsuario, Integer Genero_idGenero) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.Cuenta_nombreUsuario = Cuenta_nombreUsuario;
        this.Genero_idGenero = Genero_idGenero;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
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
