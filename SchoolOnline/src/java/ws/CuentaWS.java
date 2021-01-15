/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.ActividadDAO;
import java.sql.Date;
import java.util.Base64;
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
import pojos.Actividad;
import pojos.ActividadEntrega;
import pojos.Archivo;
import pojos.MensajeR;

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
    
    
    @Path("actividadesAlumno/{idAlumno}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActividadEntrega> obtenerActividadesAlumno(
            @PathParam("idAlumno") Integer idAlumno){
        List<ActividadEntrega> list = null;
        ActividadDAO actividadD = new ActividadDAO();
        
        try{
            list = actividadD.obtenerActividadesAlumno(idAlumno);
        }catch(Exception e){
            
        }
        return list;
        
    }
    
    @Path("obtenerActividadesEntrega/{Actividad_idActividad}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActividadEntrega> obtenerActividadesEntrega(
            @PathParam("Actividad_idActividad") Integer Actividad_idActividad){
        List<ActividadEntrega> list = null;
        ActividadDAO actividadD = new ActividadDAO();
         try{
            list = actividadD.getActividadesEntrega(Actividad_idActividad);
        }catch(Exception e){
            
        }
        return list; 
    }
    
    @Path("obtenerActividadesGrupo/{idGrupo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actividad> obtenerActividadesGrupo(
            @PathParam("idGrupo") Integer idGrupo){
        List<Actividad> list = null;
     ActividadDAO actividadD = new ActividadDAO();
         try{
            list = actividadD.getActividadesGrupo(idGrupo);
        }catch(Exception e){
            
        }
        return list; 
    }

    @Path("calificarActividad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR calificarActividad(
            @FormParam("idActividadEntrega") Integer idActividadEntrega,
            @FormParam("calificacion") Integer calificacion){
        ActividadEntrega actividadE = new ActividadEntrega();
        actividadE.setIdActividadEntrega(idActividadEntrega);
        actividadE.setCalificacion(calificacion);
        MensajeR mensajeR;
        ActividadDAO actividadD = new ActividadDAO();
        
        try{
            actividadD.calificarActividad(actividadE);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        return mensajeR;
    }
    
    @Path("modificarActividad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR modificarActividad(
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
        MensajeR mensajeR;
        ActividadDAO actividadD = new ActividadDAO();
        
        try{
            actividadD.modificarActividad(actividad);
             mensajeR = new MensajeR(true);
        }catch(Exception e){
             mensajeR = new MensajeR(false);
        }
       return mensajeR;
    }
    
    @Path("modificarActividadArchivo")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR modificarActividadArchivo(
            @FormParam("idActividad") Integer idActividad,
            @FormParam("nombre") String nombre,
            @FormParam("descripcion") String descripcion,
            @FormParam("fechaCreada") Date fechaCreada,
            @FormParam("fechaEntrega") Date fechaEntrega,
            @FormParam("archivo") String archivo){
        Actividad actividad = new Actividad();
        actividad.setNombre(nombre);
        actividad.setDescripcion(descripcion);
        actividad.setFechaCreada(fechaCreada);
        actividad.setFechaEntrega(fechaEntrega);
        actividad.setIdActividad(idActividad);
        Archivo archivoO = new Archivo();
        archivoO.setActividad_idActividad(idActividad);
        archivoO.setArchivo(archivo);
        MensajeR mensajeR;
        ActividadDAO actividadD = new ActividadDAO();
        
        try{
            actividadD.modificarActividadArchivo(actividad, archivoO);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        
        return mensajeR;
    }
    
    @Path("EntregarActividad")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR entregarActividad(
            @FormParam("archivo") String archivo,
            @FormParam("nombre") String nombre,
            @FormParam("Actividad_idActividad") Integer Actividad_idActividad,
            @FormParam("Alumno_idAlumno") Integer Alumno_idAlumno){
        ActividadEntrega actividadE = new ActividadEntrega();
        actividadE.setArchivo(archivo);
        actividadE.setNombre(nombre);
        actividadE.setActividad_idActividad(Actividad_idActividad);
        actividadE.setAlumno_idAlumno(Alumno_idAlumno);
         ActividadDAO actividadD = new ActividadDAO();
         MensajeR mensajeR;
         try{
             actividadD.entregarActividad(actividadE);
             mensajeR = new MensajeR(true);
         }catch(Exception e){
             mensajeR = new MensajeR(false);
         }
        
        return mensajeR;
    }
      
    @Path("registroActividad")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR registrarActividad(
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
        MensajeR mensajeR;
        ActividadDAO actividadD = new ActividadDAO();
        
        try{
            actividadD.registrarActividad(actividad);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
       
        return mensajeR;
    }
    
    @Path("registroActividadArchivo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR registrarActividadArchivo(
            @FormParam("nombre") String nombre,
            @FormParam("descripcion") String descripcion,
            @FormParam("fechaCreada") Date fechaCreada,
            @FormParam("fechaEntrega") Date fechaEntrega,
            @FormParam("Grupo_idGrupo") Integer Grupo_idGrupo,
            @FormParam("archivo") String archivo){
        
        Actividad actividad = new Actividad();
        actividad.setNombre(nombre);
        actividad.setDescripcion(descripcion);
        actividad.setFechaCreada(fechaCreada);
        actividad.setFechaEntrega(fechaEntrega);
        actividad.setGrupo_idGrupo(Grupo_idGrupo);
        
        ActividadDAO actividadD = new ActividadDAO();
        int idActividad = actividadD.registrarActividad(actividad);
        
        Archivo archivoO = new Archivo();
        archivoO.setActividad_idActividad(idActividad);
        archivoO.setArchivo(archivo);
        
       MensajeR mensajeR;
       
       try{
           actividadD.registrarActividadArchivo(archivoO);
           mensajeR = new MensajeR(false);
       }catch(Exception e){
           mensajeR = new MensajeR(true);
       }
        return mensajeR;
    }
        
}
