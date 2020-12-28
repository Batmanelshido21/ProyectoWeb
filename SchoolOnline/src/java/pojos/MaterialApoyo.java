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
public class MaterialApoyo {
    
    private Integer idMaterialApoyo;
    
    private String descripcion;
    
    private Integer Grupo_idGrupo;

    public MaterialApoyo() {
    }

    public MaterialApoyo(Integer idMaterialApoyo, String descripcion, Integer Grupo_idGrupo) {
        this.idMaterialApoyo = idMaterialApoyo;
        this.descripcion = descripcion;
        this.Grupo_idGrupo = Grupo_idGrupo;
    }

    public Integer getIdMaterialApoyo() {
        return idMaterialApoyo;
    }

    public void setIdMaterialApoyo(Integer idMaterialApoyo) {
        this.idMaterialApoyo = idMaterialApoyo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getGrupo_idGrupo() {
        return Grupo_idGrupo;
    }

    public void setGrupo_idGrupo(Integer Grupo_idGrupo) {
        this.Grupo_idGrupo = Grupo_idGrupo;
    }
}
