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
    
    private Integer idCuenta;
    
    private String correo;
    
    private String contrasena;
    
    private String PlantelEducativo_clave;

    public Cuenta() {
    }

    public Cuenta(Integer idCuenta, String correo, String contrasena, String PlantelEducativo_clave) {
        this.idCuenta = idCuenta;
        this.correo = correo;
        this.contrasena = contrasena;
        this.PlantelEducativo_clave = PlantelEducativo_clave;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
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
