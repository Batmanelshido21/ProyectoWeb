/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Actividad;

/**
 * REST Web Service
 *
 * @author javie
 */
@Path("actividad")
public class ActividadWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ActividadWS
     */
    public ActividadWS() {
    }

    @Path("calificarActividad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String calificarActividad(
            @FormParam("idActividad") Integer idActividad,
            @FormParam("calificacion") Integer calificacion){
        Actividad actividad = new Actividad();
        actividad.setIdActividad(idActividad);
        actividad.setCalificacion(calificacion);
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Actividad.calificarActividad",actividad);
                conexion.commit();
                return "si se pudo";
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return "no se pudo";
        
    }
    
    @Path("modificarActividad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String modificarActividad(
            @FormParam("idActividad") Integer idActividad,
            @FormParam("nombre") String nombre,
            @FormParam("descripcion") String descripcion,
            @FormParam("fechaCreada") Date fechaCreada,
            @FormParam("fechaEntrega") Date fechaEntrega){
        Actividad actividad = new Actividad();
        actividad.setNombre(nombre);
        actividad.setDescripcion(descripcion);
        actividad.setFechaCreada(fechaCreada);
        actividad.setFechaEntrega(fechaEntrega);
        actividad.setIdActividad(idActividad);
        
       SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Actividad.modificarActividad",actividad);
                conexion.commit();
                return "si se pudo";
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return "no se pudo";
        
    }
      
    
    @Path("registroActividad")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String registrarActividad(
            @FormParam("nombre") String nombre,
            @FormParam("descripcion") String descripcion,
            @FormParam("fechaCreada") Date fechaCreada,
            @FormParam("fechaEntrega") Date fechaEntrega,
            @FormParam("Grupo_idGrupo") Integer Grupo_idGrupo){
        Actividad actividad = new Actividad();
        actividad.setNombre(nombre);
        actividad.setDescripcion(descripcion);
        actividad.setFechaCreada(fechaCreada);
        actividad.setFechaEntrega(fechaEntrega);
        actividad.setGrupo_idGrupo(Grupo_idGrupo);
        
        
       SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.insert("Actividad.registrarActividad",actividad);
                conexion.commit();
                return "si se pudo";
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return "no se pudo";
        
    }
    
}
