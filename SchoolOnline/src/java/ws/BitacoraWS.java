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
import pojos.Bitacora;

/**
 * REST Web Service
 *
 * @author javie
 */
@Path("bitacora")
public class BitacoraWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BitacoraWS
     */
    public BitacoraWS() {
    }
    
    @Path("getBitacoras/{Docente_clave}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitacora> getBitacoras(
            @PathParam("clave") String clave){
        List<Bitacora> list = null;
       SqlSession conexion = MyBatisUtil.getSession();
       
       if(conexion != null){
            try{
                list = conexion.selectList("Bitacora.getBitacoraDocente",clave);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
        
    }
    
    @Path("modificarBitacora")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean modificarBitacora(
            @FormParam("fecha") Date fecha,
            @FormParam("archivo") String archivo){
        Bitacora bitacora = new Bitacora();
        bitacora.setFecha(fecha);
        byte[] archivo1 = Base64.getDecoder().decode(archivo);
        bitacora.setArchivo(archivo1);
        
         SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Bitacora.modificarBitacora",bitacora);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        
        return false;
        
    }
    
    
    @Path("registrarBitacora")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean registrarBitacora(
            @FormParam("Docente_clave") String Docente_clave,
            @FormParam("fecha") Date fecha,
            @FormParam("archivo") String archivo){
        Bitacora bitacora = new Bitacora();
        bitacora.setFecha(fecha);
        bitacora.setDocente_clave(Docente_clave);
        byte[] archivo1 = Base64.getDecoder().decode(archivo);
        bitacora.setArchivo(archivo1);
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Bitacora.registrarBitacora",bitacora);
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
