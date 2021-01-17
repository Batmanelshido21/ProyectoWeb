/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.ForoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Grupo;
import pojos.Mensaje;
import pojos.MensajeR;

/**
 * REST Web Service
 *
 * @author javie
 */
@Path("foro")
public class ForoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ForoWS
     */
    public ForoWS() {
    }
    
    @Path("enviarMensaje")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR enviarMensajeDocente(
            @FormParam("mensaje") String mensaje,
            @FormParam("Foro_idForo") Integer Foro_idForo,
            @FormParam("Cuenta_nombreUsuario") String Cuenta_nombreUsuario){
        Mensaje mensajeO = new Mensaje();
        mensajeO.setMensaje(mensaje);
        mensajeO.setForo_idForo(Foro_idForo);
        mensajeO.setCuenta_nombreUsuario(Cuenta_nombreUsuario);
        MensajeR mensajeR;
        ForoDAO foroD = new ForoDAO();
        
        try{
            foroD.enviarMensaje(mensajeO);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        return mensajeR;
    }
    
    
    @Path("mensajeForo/{Foro_idForo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mensaje> obtenerMensajes(
            @PathParam("Foro_idForo") Integer Foro_idForo){
        List<Mensaje> list = null;
       SqlSession conexion = MyBatisUtil.getSession();
       ForoDAO foroD = new ForoDAO();
       
       try{
           list = foroD.obtenerMensajes(Foro_idForo);
       }catch(Exception e){
           
       }
       
        return list;
    }
    
    @Path("idForo/{idGrupo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Grupo obtenerIdForo(
            @PathParam("idGrupo")Integer idGrupo){
        ForoDAO foroD = new ForoDAO();
        Integer idGrupoR = null;
        Grupo grupo = new Grupo();
        try{
          grupo = foroD.obtenerForoId(idGrupo);
          grupo.setIdGrupo(idGrupo);
        }catch(Exception e){
            System.out.println(e);
        }
        return grupo;
    }

}
