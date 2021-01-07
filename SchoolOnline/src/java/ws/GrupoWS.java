/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.GrupoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Foro;
import pojos.Grupo;
import pojos.MensajeR;

/**
 * REST Web Service
 *
 * @author javie
 */
@Path("grupo")
public class GrupoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GrupoWS
     */
    public GrupoWS() {
    }
    
    @Path("getGrupoDocente/{clave}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Grupo> getGruposDocente(
            @PathParam("clave") String clave){
       List<Grupo> list = null;
       GrupoDAO grupoD = new GrupoDAO();
       try{
           list = grupoD.obtenerGrupodID(clave);
       }catch(Exception e){
           
       }
        return list;
    }
    
    @Path("modificarGrupo")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR modificarGrupo(
            @FormParam("idGrupo") Integer idGrupo,
            @FormParam("nombre") String nombre){
        Grupo grupo = new Grupo();
        grupo.setIdGrupo(idGrupo);
        grupo.setNombre(nombre);
        MensajeR mensajeR;
        GrupoDAO grupoD = new GrupoDAO();
        
        try{
            grupoD.modificarGrupo(grupo);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        return mensajeR;
    }

    @Path("RegistrarGrupo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR crearGrupo(
            @FormParam("Foro_idForo") Integer Foro_idForo,
            @FormParam("nombreF") String nombreF,
            @FormParam("nombre") String nombre,
            @FormParam("CicloEscolar_idCicloEscolar") Integer CicloEscolar_idCicloEscolar,
            @FormParam("Docente_clave") String Docente_clave){
        
        Grupo grupo = new Grupo();
        grupo.setNombre(nombre);
        grupo.setCicloEscolar_idCicloEscolar(CicloEscolar_idCicloEscolar);
        grupo.setForo_idForo(Foro_idForo);
        grupo.setDocente_clave(Docente_clave);
        Foro  foro = new Foro();
        foro.setIdForo(Foro_idForo);
        foro.setNombre(nombreF);
       
        MensajeR mensajeR;
        GrupoDAO grupoD = new GrupoDAO();
        try{
            grupoD.crearGrupo(foro, grupo);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        return mensajeR;
    }
    
}
