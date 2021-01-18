/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Alumno;
import pojos.Cuenta;
import pojos.CuentaGrupo;
import pojos.Docente;
import pojos.ObjetoRetorno;

/**
 *
 * @author javie
 */
public class CuentaDAO {

    public CuentaDAO() {
    }
    
        public boolean registrarAlumno(Cuenta cuenta, Alumno alumno, Integer Grupo_idGrupo) {
         SqlSession conexion = MyBatisUtil.getSession();
         CuentaGrupo cuentaG = new CuentaGrupo();
         cuentaG.setGrupo_idGrupo(Grupo_idGrupo);
        if(conexion != null){
            try{
                conexion.insert("Cuenta.registrarCuenta",cuenta);
                conexion.insert("Cuenta.registrarAlumno",alumno);
                cuentaG.setAlumno_idAlumno(conexion.selectOne("Cuenta.getAlumnoId",cuenta.getNombreUsuario()));
                conexion.insert("Cuenta.registrarAlumnoGrupo",cuentaG);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }
        
    public boolean registrarAlumno(Cuenta cuenta,Alumno alumno){
        
       SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                conexion.insert("Cuenta.registrarCuenta",cuenta);
                conexion.insert("Cuenta.registrarAlumno",alumno);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }
    
     public boolean registrarAlumnoNU(String nombreUsuario, CuentaGrupo cuentaG) {
        SqlSession conexion = MyBatisUtil.getSession();
        try{
            cuentaG.setAlumno_idAlumno(conexion.selectOne("Cuenta.getAlumnoId",nombreUsuario));
            conexion.insert("Cuenta.registrarAlumnoGrupo",cuentaG);
            conexion.commit();
                return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public boolean registrarDocente(Cuenta cuenta, Docente docente){
        SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                conexion.insert("Cuenta.registrarCuenta",cuenta);
                conexion.insert("Cuenta.registrarDocente",docente);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }
    
    public boolean modificarDocente(Docente docente){
        SqlSession conn = MyBatisUtil.getSession();
        
         try {
            conn.update("Cuenta.modificarDocente", docente);
            conn.commit();
            return true;
        } catch (Exception ex) {
            
        } finally {
            conn.close();
        }
        
        return false;
    }

    public void modificarContrasena(Cuenta cuenta) {
            SqlSession conn = MyBatisUtil.getSession();
        
         try {
            conn.update("Cuenta.modificarContrasena", cuenta);
            conn.commit();
        } catch (Exception ex) {
            
        } finally {
            conn.close();
        } 
    }

  public ObjetoRetorno login(Cuenta cuenta) {

        SqlSession conexion = MyBatisUtil.getSession();
        ObjetoRetorno objeto = new ObjetoRetorno();
        String nombreUsuario;

        if (conexion != null) {
            try {

                cuenta.setNombreUsuario(conexion.selectOne("Cuenta.login", cuenta));
                cuenta.setRol(conexion.selectOne("Cuenta.login2", cuenta));
                cuenta.setPlantelEducativo_clave(conexion.selectOne("Cuenta.login3", cuenta));

                objeto.setRol(cuenta.getRol());
                nombreUsuario = cuenta.getNombreUsuario();

                if (cuenta.getRol() != null) {
                    
                    if (cuenta.getRol().equalsIgnoreCase("Plantel")) {
                        objeto.setClave(cuenta.getPlantelEducativo_clave());
                    }
                    if (cuenta.getRol().equalsIgnoreCase("Docente")) {
                        objeto.setClave(cuenta.getPlantelEducativo_clave());
                        objeto.setId(conexion.selectOne("Cuenta.getDocenteId", nombreUsuario));
                        objeto.setNombre(conexion.selectOne("Cuenta.getDocenteNombre", nombreUsuario));
                    }
                    if (cuenta.getRol().equalsIgnoreCase("Alumno")) {
                        objeto.setId(conexion.selectOne("Cuenta.getAlumnoId", nombreUsuario));
                        objeto.setNombre(conexion.selectOne("Cuenta.getAlumnoNombre", nombreUsuario));
                    }
                    conexion.commit();
                    return objeto;

                } else {
                    
                    objeto.setId(0);

                    return objeto;
                }
            } finally {
                String j = conexion.toString();
                conexion.close();
            }
        }
        return objeto;
    }

     public Alumno obtenerNombreAlumno(int idAlumno) {
        SqlSession conn = MyBatisUtil.getSession();
        Alumno alumno = new Alumno();
        
        try {

            alumno = conn.selectOne("Cuenta.getNombreAlumno", idAlumno);
            
            return alumno;
        } catch (Exception ex) {

        } finally {
            conn.close();
        }
        
        return alumno;
    }
    
}
