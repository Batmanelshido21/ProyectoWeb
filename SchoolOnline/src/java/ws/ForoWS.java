/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

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
import pojos.Mensaje;

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
    
    @Path("enviarMensajeDocente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean enviarMensajeDocente(
            @FormParam("mensaje") String mensaje,
            @FormParam("Foro_idForo") Integer Foro_idForo,
            @FormParam("Docente_clave") String Docente_clave){
        Mensaje mensajeO = new Mensaje();
        mensajeO.setMensaje(mensaje);
        mensajeO.setForo_idForo(Foro_idForo);
        mensajeO.setDocente_clave(Docente_clave);
        
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Foro.enviarMensajeDocente",mensajeO);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
        
    }
    
    @Path("enviarMensajeAlumno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean enviarMensajeAlumno(
            @FormParam("mensaje") String mensaje,
            @FormParam("Foro_idForo") Integer Foro_idForo,
            @FormParam("Alumno_clave") String Alumno_clave){
        Mensaje mensajeO = new Mensaje();
        mensajeO.setMensaje(mensaje);
        mensajeO.setForo_idForo(Foro_idForo);
        mensajeO.setDocente_clave(Alumno_clave);
        
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Foro.enviarMensajeAlumno",mensajeO);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
        
    }
    
    @Path("mensajeForo/{Foro_idForo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mensaje> obtenerMensajes(
            @PathParam("Foro_idForo") Integer Foro_idForo){
        List<Mensaje> list = null;
       SqlSession conexion = MyBatisUtil.getSession();
       
       if(conexion != null){
            try{
                list = conexion.selectList("Foro.getMensajesForo",Foro_idForo);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
    }

}
