/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.CuentaDAO;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import pojos.CuentaGrupo;
import pojos.Docente;
import pojos.MensajeR;
import pojos.ObjetoRetorno;

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
    
    @Path("Login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ObjetoRetorno loginDeUsuario(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena){
        Cuenta cuenta = new Cuenta();
        ObjetoRetorno objeto = new ObjetoRetorno();
        CuentaDAO cuentaD = new CuentaDAO();
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        try{
            objeto = cuentaD.login(cuenta);
        }catch(Exception e){
            System.out.println(e);
        }
        
        return objeto;
        
    }
    
    
    @Path("modificarContrasena")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR modificarContraseña(
            @FormParam("correo") String correo,
            @FormParam("contrasena") String contrasena){
        MensajeR mensajeR;
        CuentaDAO cuentaD = new CuentaDAO();
        Cuenta cuenta = new Cuenta();
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        
        try{
            cuentaD.modificarContrasena(cuenta);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
            mensajeR = new MensajeR(false);
        }
        return mensajeR;
        
    }
    
    
    @Path("recuperarContraseña")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeR recuperarContraseña(
            @FormParam("correo") String correo){
        Cuenta cuenta = new Cuenta();
        cuenta.setCorreo(correo);
        MensajeR mensajeR;
        
        SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                cuenta = conexion.selectOne("Cuenta.recuperarContraseña",cuenta);
                conexion.commit();
                Properties propiedad = new Properties();
                propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
                propiedad.setProperty("mail.smtp.starttls.enable", "true");
                propiedad.setProperty("mail.smtp.port", "587");
                propiedad.setProperty("mail.smtp.auth", "true");
                
                Session sesion = Session.getDefaultInstance(propiedad);
                String correoEnvia = "onlineschool847@gmail.com";
                String contrasena = "educacionenlinea234";
                String destinatario = cuenta.getCorreo();
                String asunto = "Recuperacion de contraseña";
                String mensaje = "Tu contraseña es: "+cuenta.getContrasena();
                    
                MimeMessage mail = new MimeMessage(sesion);
                try {
                    mail.setFrom(new InternetAddress (correoEnvia));
                    mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                    mail.setSubject(asunto);
                    mail.setText(mensaje);
                    
                    Transport transporte = sesion.getTransport("smtp");
                    transporte.connect(correoEnvia,contrasena);
                    transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                    transporte.close();
                    mensajeR = new MensajeR(true);
                    return mensajeR;
                } catch (AddressException ex) {
                    mensajeR = new MensajeR(false);
                    Logger.getLogger(CuentaWS.class.getName()).log(Level.SEVERE, null, ex);
                    return mensajeR;
                } catch (MessagingException ex) {
                    mensajeR = new MensajeR(false);
                    Logger.getLogger(CuentaWS.class.getName()).log(Level.SEVERE, null, ex);
                    return mensajeR;
                }
 
            }catch(Exception e){
                mensajeR = new MensajeR(false);
                return mensajeR;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return null;
        
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
            @FormParam("PlantelEducativo_clave")String PlantelEducativo_clave,
            @FormParam("rol") String rol,
            @FormParam("Grupo_idGrupo") Integer Grupo_idGrupo){
        MensajeR mensajeR;
        Cuenta cuenta = new Cuenta();
        Alumno alumno = new Alumno();
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        cuenta.setPlantelEducativo_clave(PlantelEducativo_clave);
        cuenta.setNombreUsuario(nombreUsuario);
        cuenta.setRol(rol);
        
        alumno.setNombre(nombre);
        alumno.setApellidoPaterno(apellidoPaterno);
        alumno.setApellidoMaterno(apellidoMaterno);
        alumno.setGenero_idGenero(Genero_idGenero);
        alumno.setCuenta_nombreUsuario(nombreUsuario);
        CuentaGrupo cuentaG = new CuentaGrupo();
        
    
        CuentaDAO cuentaD = new CuentaDAO();
        try{
            cuentaD.registrarAlumno(cuenta, alumno,Grupo_idGrupo);
            mensajeR = new MensajeR(true);
        }catch(Exception e){
             mensajeR = new MensajeR(false);
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
            @FormParam("PlantelEducativo_clave")String PlantelEducativo_clave,
            @FormParam("rol") String rol){
        Cuenta cuenta = new Cuenta();
        Docente docente = new Docente();
        
        cuenta.setPlantelEducativo_clave(PlantelEducativo_clave);
        cuenta.setCorreo(correo);
        cuenta.setContrasena(contrasena);
        cuenta.setNombreUsuario(nombreUsuario);
        cuenta.setRol(rol);
        
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
