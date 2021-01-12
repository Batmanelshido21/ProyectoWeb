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
    
   private String Cuenta_nombreUsuario;

    public Mensaje() {
    }

    public Mensaje(Integer idMensaje, String mensaje, Integer Foro_idForo, String Cuenta_nombreUsuario) {
        this.idMensaje = idMensaje;
        this.mensaje = mensaje;
        this.Foro_idForo = Foro_idForo;
        this.Cuenta_nombreUsuario = Cuenta_nombreUsuario;
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

    public String getCuenta_nombreUsuario() {
        return Cuenta_nombreUsuario;
    }

    public void setCuenta_nombreUsuario(String Cuenta_nombreUsuario) {
        this.Cuenta_nombreUsuario = Cuenta_nombreUsuario;
    }

   
}
