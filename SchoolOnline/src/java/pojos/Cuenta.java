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
public class Cuenta {
    
    private String nombreUsuario;
    
    private String rol;
    
    private String correo;
    
    private String contrasena;
    
    private String PlantelEducativo_clave;

    public Cuenta() {
    }

    public Cuenta(String nombreUsuario, String rol, String correo, String contrasena, String PlantelEducativo_clave) {
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
        this.correo = correo;
        this.contrasena = contrasena;
        this.PlantelEducativo_clave = PlantelEducativo_clave;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPlantelEducativo_clave() {
        return PlantelEducativo_clave;
    }

    public void setPlantelEducativo_clave(String PlantelEducativo_clave) {
        this.PlantelEducativo_clave = PlantelEducativo_clave;
    }

   
}
