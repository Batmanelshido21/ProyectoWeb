/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Alumno;
import pojos.Cuenta;
import pojos.Docente;

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
    
    @Path("prueba")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCuenta(){
        
        return "Hola";
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
       Alumno alumno = new Alumno();
       int idCuenta;
       SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                idCuenta = conexion.selectOne("Cuenta.login",cuenta);
                alumno = conexion.selectOne("Cuenta.getAlumno",idCuenta);
                conexion.commit();
                return alumno;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return alumno;
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
       int idCuenta;
       SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                idCuenta = conexion.selectOne("Cuenta.login",cuenta);
                docente = conexion.selectOne("Cuenta.getDocente",idCuenta);
                conexion.commit();
                return docente;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return docente;
    }
    
    
    @Path("RegistrarAlumno")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String registroUSuario(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena,
            @FormParam("clave") String clave,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("idCuenta") Integer idCuenta,
            @FormParam("Genero_idGenero") Integer Genero_idGenero,
            @FormParam("PlantelEducativo_clave")String PlantelEducativo_clave){
        
        Cuenta cuenta = new Cuenta();
        Alumno alumno = new Alumno();
        cuenta.setIdCuenta(idCuenta);
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        cuenta.setPlantelEducativo_clave(PlantelEducativo_clave);
        alumno.setClave(clave);
        alumno.setNombre(nombre);
        alumno.setApellidoPaterno(apellidoPaterno);
        alumno.setApellidoMaterno(apellidoMaterno);
        alumno.setGenero_idGenero(Genero_idGenero);
        alumno.setCuenta_idCuenta(idCuenta);
    
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.insert("Cuenta.registrarCuenta",cuenta);
                conexion.insert("Cuenta.registrarAlumno",alumno);
                conexion.commit();
                return "si se pudo";
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return "no se pudo";
        
    }
    
    
    @Path("RegistrarDocente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String registrarDocente(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena,
            @FormParam("clave") String clave,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("gradoAcademico") String gradoAcademico,
            @FormParam("telefono") String telefono,
            @FormParam("Cuenta_idCuenta") Integer Cuenta_idCuenta,
            @FormParam("Genero_idGenero") Integer Genero_idGenero,
            @FormParam("PlantelEducativo_clave")String PlantelEducativo_clave){
        Cuenta cuenta = new Cuenta();
        Docente docente = new Docente();
        
        cuenta.setPlantelEducativo_clave(PlantelEducativo_clave);
        cuenta.setIdCuenta(Cuenta_idCuenta);
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        docente.setClave(clave);
        docente.setNombre(nombre);
        docente.setApellidoPaterno(apellidoPaterno);
        docente.setApellidoMaterno(apellidoMaterno);
        docente.setGradoAcademico(gradoAcademico);
        docente.setTelefono(telefono);
        docente.setCuenta_idCuenta(Cuenta_idCuenta);
        docente.setGenero_idGenero(Genero_idGenero);
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.insert("Cuenta.registrarCuenta",cuenta);
                conexion.insert("Cuenta.registrarDocente",docente);
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
