/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.PlantelEducativoDAO;
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
import pojos.Cuenta;
import pojos.Docente;
import pojos.MensajeR;
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
    
    @Path("getDocete/{clave}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Docente> getBitacoras(
            @PathParam("clave") String clave){
        List<Docente> list = null;
        PlantelEducativoDAO plantelD = new PlantelEducativoDAO();
        try{
            list = plantelD.obtenerDocentes(clave);
        }catch(Exception e){
            
        }
        return list; 
    }
    
    @Path("LoginPlantel")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public PlantelEducativo loginAlumno(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena){
       Cuenta cuenta = new Cuenta();
       cuenta.setCorreo(correo);
       cuenta.setContrasena(contrasena);
       PlantelEducativoDAO plantelD = new PlantelEducativoDAO();
       PlantelEducativo plantel = new PlantelEducativo();
       
       try{
           plantel = plantelD.loginPlantel(cuenta);
       }catch(Exception e){
           
       }
       return plantel;
    }
    
    
    @Path("modificarPlantel")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR modificarPlantel(
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
        MensajeR mensajeR;
        PlantelEducativoDAO plantelD = new PlantelEducativoDAO();
        
        try{
            plantelD.modificarPlantelEducativo(plantel);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        return mensajeR;
    }
    
    
    
    @Path("RegistrarPlantel")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR registroPlantel(
            @FormParam("clave") String clave,
            @FormParam("sector") String sector,
            @FormParam("nivelEscolar") String nivelEscolar,
            @FormParam("zona") String zona,
            @FormParam("direccion") String direccion,
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena,
            @FormParam("nombreUsuario") String nombreUsuario){
        
        System.out.println("Entro al registro");
        
        PlantelEducativo plantel = new PlantelEducativo();
        plantel.setClave(clave);
        plantel.setSector(sector);
        plantel.setNivelEscolar(nivelEscolar);
        plantel.setZona(zona);
        plantel.setDireccion(direccion);
        Cuenta cuenta = new Cuenta();
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        cuenta.setPlantelEducativo_clave(clave);
        cuenta.setNombreUsuario(nombreUsuario);
        MensajeR mensajeR;
        PlantelEducativoDAO plantelD = new PlantelEducativoDAO();
        
        try{
            plantelD.registrarPlantelEducativo(plantel,cuenta);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            mensajeR = new MensajeR(false);
        }
        
        return mensajeR;
    }

}
