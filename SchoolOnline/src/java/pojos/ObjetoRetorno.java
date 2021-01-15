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
public class ObjetoRetorno {
    
    private Integer id;
    
    private String clave;
    
    private String rol;
    
    private String nombre;

    public ObjetoRetorno() {
    }

    public ObjetoRetorno(Integer id, String clave, String rol, String nombre) {
        this.id = id;
        this.clave = clave;
        this.rol = rol;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
