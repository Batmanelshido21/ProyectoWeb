/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Actividad;
import pojos.ActividadEntrega;
import pojos.Archivo;

/**
 *
 * @author javie
 */
public class ActividadDAO {

    public ActividadDAO() {
    }
    
    public int registrarActividad(Actividad actividad){
        SqlSession conexion = MyBatisUtil.getSession();
        
        int idActividad = 0;
        
        if(conexion != null){
            try{
                conexion.insert("Actividad.registrarActividad",actividad);
                conexion.commit();
                
                idActividad = conexion.selectOne("Actividad.getActividad", actividad.getNombre());
                
                return idActividad;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return 0;
    }
    
    public boolean entregarActividad(ActividadEntrega actividadE){
        SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                conexion.insert("Actividad.registrarActividadEntrega",actividadE);
                conexion.commit();
                return true;
            }catch(Exception e){
                 System.out.println(e);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }   
        return false;   
    }
    
    public boolean registrarActividadArchivo(Archivo archivo){
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.insert("Actividad.registrarActividadArchivo",archivo);
                conexion.commit();
                return true;
            }catch(Exception e){
                 System.out.println(e);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }
    
    public boolean modificarActividad(Actividad actividad){
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
    
    public boolean modificarActividadArchivo(Actividad actividad, Archivo archivo){
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
    
    public boolean calificarActividad(ActividadEntrega actividad){
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                System.out.println("aqui");
                System.out.println(actividad.getActividad_idActividad());
                System.out.println(actividad.getCalificacion());
                conexion.update("Actividad.calificarActividad",actividad);
                System.out.println("aqui");
                conexion.commit();
                return true;
            }catch(Exception e){
            System.out.println(e);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }
    
    public List<ActividadEntrega> obtenerActividadesAlumno(Integer idAlumno){
        List<ActividadEntrega> list = null;
        SqlSession conexion = MyBatisUtil.getSession();
        
         if(conexion != null){
            try{
                list = conexion.selectList("Actividad.getActividadesAlumno",idAlumno);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
    }
    

    public List<ActividadEntrega> getActividadesEntrega(Integer Actividad_idActividad) {
         List<ActividadEntrega> list = null;
        SqlSession conexion = MyBatisUtil.getSession();
        
         if(conexion != null){
            try{
                list = conexion.selectList("Actividad.getActividadesEntrega",Actividad_idActividad);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
    }

    public List<Actividad> getActividadesGrupo(Integer idGrupo) {
        List<Actividad> list = null;
        SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                list = conexion.selectList("Actividad.getActividadesGrupo",idGrupo);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
    }
}
