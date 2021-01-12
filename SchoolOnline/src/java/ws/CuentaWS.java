/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.CuentaDAO;
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
import pojos.Alumno;
import pojos.Cuenta;
import pojos.Docente;
import pojos.MensajeR;

/**
 * REST Web Service
 *
 * @author javie
 */
@Path("cuenta")
public class CuentaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CuentaWS
     */
    public CuentaWS() {
    }
    
    @Path("LoginAlumno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno loginAlumno(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena){
       Cuenta cuenta = new Cuenta();
       cuenta.setCorreo(correo);
       cuenta.setContrasena(contrasena);
       CuentaDAO cuentaD = new CuentaDAO();
       Alumno alumno = new Alumno();
       
       try{
           alumno = cuentaD.loginAlumno(cuenta);
       }catch(Exception e){
           
       }
       return alumno;
    }
    
    @Path("recuperarContraseña")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Cuenta recuperarContraseña(
            @FormParam("correo") String correo){
        Cuenta cuenta = new Cuenta();
        cuenta.setCorreo(correo);
        
        SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                cuenta = conexion.selectOne("Cuenta.recuperarContraseña",cuenta);
                conexion.commit();
                return cuenta;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return cuenta;
        
    }
    
    
    @Path("LoginDocente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Docente loginDocente(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena){
       Cuenta cuenta = new Cuenta();
       cuenta.setCorreo(correo);
       cuenta.setContrasena(contrasena);
       Docente docente = new Docente();
       CuentaDAO cuentaD = new CuentaDAO();
       
       try{
           docente = cuentaD.loginDocente(cuenta);
       }catch(Exception e){
           
       }
       return docente;
    }
    
    
    @Path("RegistrarAlumno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR registroUSuario(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena,
            @FormParam("nombreUsuario") String nombreUsuario,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("Genero_idGenero") Integer Genero_idGenero,
            @FormParam("PlantelEducativo_clave")String PlantelEducativo_clave){
        MensajeR mensajeR;
        Cuenta cuenta = new Cuenta();
        Alumno alumno = new Alumno();
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        cuenta.setPlantelEducativo_clave(PlantelEducativo_clave);
        cuenta.setNombreUsuario(nombreUsuario);
        
        alumno.setNombre(nombre);
        alumno.setApellidoPaterno(apellidoPaterno);
        alumno.setApellidoMaterno(apellidoMaterno);
        alumno.setGenero_idGenero(Genero_idGenero);
        alumno.setCuenta_nombreUsuario(nombreUsuario);
    
        CuentaDAO cuentaD = new CuentaDAO();
        try{
            cuentaD.registrarAlumno(cuenta, alumno);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
             mensajeR = new MensajeR(true);
        }
        return mensajeR;
    }
    
    @Path("modificarDocente")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR modificarDocente(
            @FormParam("idDocente") Integer idDocente,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("gradoAcademico") String gradoAcademico,
            @FormParam("telefono") String telefono){
        
        Docente docente = new Docente();
        docente.setIdDocente(idDocente);
        docente.setNombre(nombre);
        docente.setApellidoPaterno(apellidoPaterno);
        docente.setApellidoMaterno(apellidoMaterno);
        docente.setGradoAcademico(gradoAcademico);
        docente.setTelefono(telefono);
        MensajeR mensajeR;
         
        CuentaDAO cuentaD = new CuentaDAO();
        try{
            cuentaD.modificarDocente(docente);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        
        return mensajeR;
    }
    
    
    
    @Path("RegistrarDocente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR registrarDocente(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena,
            @FormParam("nombreUsuario") String nombreUsuario,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("gradoAcademico") String gradoAcademico,
            @FormParam("telefono") String telefono,
            @FormParam("Genero_idGenero") Integer Genero_idGenero,
            @FormParam("PlantelEducativo_clave")String PlantelEducativo_clave){
        Cuenta cuenta = new Cuenta();
        Docente docente = new Docente();
        
        cuenta.setPlantelEducativo_clave(PlantelEducativo_clave);
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        cuenta.setNombreUsuario(nombreUsuario);
        
        docente.setNombre(nombre);
        docente.setApellidoPaterno(apellidoPaterno);
        docente.setApellidoMaterno(apellidoMaterno);
        docente.setGradoAcademico(gradoAcademico);
        docente.setTelefono(telefono);
        docente.setGenero_idGenero(Genero_idGenero);
        docente.setCuenta_nombreUsuario(nombreUsuario);
        docente.setPlantelEducativo_clave(PlantelEducativo_clave);
        MensajeR mensajeR;
        CuentaDAO cuentaD = new CuentaDAO();
        try{
            cuentaD.registrarDocente(cuenta, docente);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        return mensajeR;
    }
    
}
