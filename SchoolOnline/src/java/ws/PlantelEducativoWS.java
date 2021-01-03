/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.PlantelEducativo;

/**
 * REST Web Service
 *
 * @author javie
 */
@Path("plantel")
public class PlantelEducativoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PlantelEducativoWS
     */
    public PlantelEducativoWS() {
    }
    
    @Path("modificarPlantel")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean modificarPlantel(
            @FormParam("clave") String clave,
            @FormParam("sector") String sector,
            @FormParam("nivelEscolar") String nivelEscolar,
            @FormParam("zona") String zona,
            @FormParam("direccion") String direccion){
        PlantelEducativo plantel = new PlantelEducativo();
        plantel.setClave(clave);
        plantel.setSector(sector);
        plantel.setNivelEscolar(nivelEscolar);
        plantel.setZona(zona);
        plantel.setDireccion(direccion);
         SqlSession conn = MyBatisUtil.getSession();
        
         try {
            conn.update("Plantel.modificarPlantel", plantel);
            conn.commit();
            return true;
        } catch (Exception ex) {
            
        } finally {
            conn.close();
        }
        
        return false;
    }
    
    
    
    @Path("RegistrarPlantel")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean registroPlantel(
            @FormParam("clave") String clave,
            @FormParam("sector") String sector,
            @FormParam("nivelEscolar") String nivelEscolar,
            @FormParam("zona") String zona,
            @FormParam("direccion") String direccion){
        
        PlantelEducativo plantel = new PlantelEducativo();
        plantel.setClave(clave);
        plantel.setSector(sector);
        plantel.setNivelEscolar(nivelEscolar);
        plantel.setZona(zona);
        plantel.setDireccion(direccion);
        
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.insert("Plantel.registrarPlantel",plantel);
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
