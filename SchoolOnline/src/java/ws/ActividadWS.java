/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

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
import pojos.Archivo;

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
    
    @Path("actividadesGrupo/{Grupo_idGrupo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actividad> obtenerActividadesGrupo(
            @PathParam("Grupo_idGrupo") Integer Grupo_idGrupo){
        List<Actividad> list = null;
        SqlSession conexion = MyBatisUtil.getSession();
        
         if(conexion != null){
            try{
                list = conexion.selectList("Actividad.getActividadesdGrupo",Grupo_idGrupo);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
        
    }
    
    @Path("actividadesAlumno/{Alumno_clave}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actividad> obtenerActividadesGrupo(
            @PathParam("Alumno_clave") String Alumno_clave){
        List<Actividad> list = null;
        SqlSession conexion = MyBatisUtil.getSession();
        
         if(conexion != null){
            try{
                list = conexion.selectList("Actividad.getActividadesAlumno",Alumno_clave);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
        
    }

    @Path("calificarActividad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean calificarActividad(
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
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
        
    }
    
    @Path("modificarActividad")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean modificarActividad(
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
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
        
    }
    
    @Path("modificarActividadArchivo")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean modificarActividadArchivo(
            @FormParam("idActividad") Integer idActividad,
            @FormParam("nombre") String nombre,
            @FormParam("descripcion") String descripcion,
            @FormParam("fechaCreada") Date fechaCreada,
            @FormParam("fechaEntrega") Date fechaEntrega,
            @FormParam("archivo") String archivo){
        byte[] archivo1 = Base64.getDecoder().decode(archivo);
        Actividad actividad = new Actividad();
        actividad.setNombre(nombre);
        actividad.setDescripcion(descripcion);
        actividad.setFechaCreada(fechaCreada);
        actividad.setFechaEntrega(fechaEntrega);
        actividad.setIdActividad(idActividad);
        Archivo archivoO = new Archivo();
        archivoO.setActividad_idActividad(idActividad);
        archivoO.setArchivo(archivo1);
        
       SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Actividad.modificarActividad",actividad);
                conexion.update("Actividad.modificarArchivo",archivo);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
        
    }
      
    @Path("registroActividad")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean registrarActividad(
            @FormParam("idActividad") Integer idActividad,
            @FormParam("nombre") String nombre,
            @FormParam("descripcion") String descripcion,
            @FormParam("fechaCreada") Date fechaCreada,
            @FormParam("fechaEntrega") Date fechaEntrega,
            @FormParam("Grupo_idGrupo") Integer Grupo_idGrupo,
            @FormParam("Alumno_clave") String Alumno_clave){
        Actividad actividad = new Actividad();
        actividad.setIdActividad(idActividad);
        actividad.setNombre(nombre);
        actividad.setDescripcion(descripcion);
        actividad.setFechaCreada(fechaCreada);
        actividad.setFechaEntrega(fechaEntrega);
        actividad.setGrupo_idGrupo(Grupo_idGrupo);
        actividad.setAlumno_clave(Alumno_clave);
        
       SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.insert("Actividad.registrarActividad",actividad);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
        
    }
    
    @Path("registroActividadArchivo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean registrarActividadArchivo(
            @FormParam("idActividad") Integer idActividad,
            @FormParam("nombre") String nombre,
            @FormParam("descripcion") String descripcion,
            @FormParam("fechaCreada") Date fechaCreada,
            @FormParam("fechaEntrega") Date fechaEntrega,
            @FormParam("Grupo_idGrupo") Integer Grupo_idGrupo,
            @FormParam("Alumno_clave") String Alumno_clave,
            @FormParam("archivo") String archivo){
        byte[] archivo1 = Base64.getDecoder().decode(archivo);
        Actividad actividad = new Actividad();
        actividad.setIdActividad(idActividad);
        actividad.setNombre(nombre);
        actividad.setDescripcion(descripcion);
        actividad.setFechaCreada(fechaCreada);
        actividad.setFechaEntrega(fechaEntrega);
        actividad.setGrupo_idGrupo(Grupo_idGrupo);
        actividad.setAlumno_clave(Alumno_clave);
        Archivo archivoO = new Archivo();
        archivoO.setActividad_idActividad(idActividad);
        archivoO.setArchivo(archivo1);
        
       SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.insert("Actividad.registrarActividad",actividad);
                conexion.insert("Actividad.registrarActividadArchivo",archivo);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
        
    }
        
}
