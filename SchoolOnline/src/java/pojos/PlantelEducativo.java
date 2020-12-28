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
public class PlantelEducativo {
    
    private String clave;
    
    private String sector;
    
    private String nivelEscolar;
    
    private String zona;
    
    private String direccion;

    public PlantelEducativo() {
    }

    public PlantelEducativo(String clave, String sector, String nivelEscolar, String zona, String direccion) {
        this.clave = clave;
        this.sector = sector;
        this.nivelEscolar = nivelEscolar;
        this.zona = zona;
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
