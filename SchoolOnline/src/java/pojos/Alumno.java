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
    
    private String clave;
    
    private String nombre;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private Integer Cuenta_idCuenta;
    
    private Integer Genero_idGenero;

    public Alumno() {
    }

    public Alumno(String clave, String nombre, String apellidoPaterno, String apellidoMaterno, Integer Cuenta_idCuenta, Integer Genero_idGenero) {
        this.clave = clave;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.Cuenta_idCuenta = Cuenta_idCuenta;
        this.Genero_idGenero = Genero_idGenero;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public Integer getCuenta_idCuenta() {
        return Cuenta_idCuenta;
    }

    public void setCuenta_idCuenta(Integer Cuenta_idCuenta) {
        this.Cuenta_idCuenta = Cuenta_idCuenta;
    }

    public Integer getGenero_idGenero() {
        return Genero_idGenero;
    }

    public void setGenero_idGenero(Integer Genero_idGenero) {
        this.Genero_idGenero = Genero_idGenero;
    }

    
    
    
}
