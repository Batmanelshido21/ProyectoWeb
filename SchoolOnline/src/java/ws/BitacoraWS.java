/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.BitacoraDAO;
import java.sql.Date;
import java.util.Arrays;
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
import pojos.MensajeR;

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
    
    @Path("getBitacoras/{Docente_idDocente}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitacora> getBitacoras(
            @PathParam("Docente_idDocente") Integer Docente_idDocente){
        List<Bitacora> list = null;
        BitacoraDAO bitacoraD = new BitacoraDAO();
        try{
            list = bitacoraD.getBitacoras(Docente_idDocente);
        }catch(Exception e){
            
        }
        return list; 
    }
    
    @Path("modificarBitacora")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR modificarBitacora(
            @FormParam("idBitacora") Integer idBitacora,
            @FormParam("fecha") Date fecha,
            @FormParam("archivo") String archivo){
        Bitacora bitacora = new Bitacora();
        bitacora.setIdBitacora(idBitacora);
        bitacora.setFecha(fecha);
        bitacora.setArchivo(archivo);
        MensajeR mensajeR;
        BitacoraDAO bitacoraD = new BitacoraDAO();
        
        try{
            bitacoraD.modificarBitacora(bitacora);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
         
        return mensajeR;
    }
    
    
    @Path("registrarBitacora")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR registrarBitacora(
            @FormParam("Docente_idDocente") Integer Docente_idDocente,
            @FormParam("fecha") Date fecha,
            @FormParam("archivo") String archivo){
        Bitacora bitacora = new Bitacora();
        bitacora.setFecha(fecha);
        bitacora.setDocente_idDocente(Docente_idDocente);
        bitacora.setArchivo(archivo);
        MensajeR mensajeR;
        BitacoraDAO bitacoraD = new BitacoraDAO();
        
        try{
            bitacoraD.registrarBitacora(bitacora);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        return mensajeR;
    }

  
}
