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
import pojos.Archivo;

/**
 *
 * @author javie
 */
public class ActividadDAO {

    public ActividadDAO() {
    }
    
    public boolean registrarActividad(Actividad actividad){
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
    
    public boolean registrarActividadArchivo(Actividad actividad, Archivo archivo){
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
    
    public boolean calificarActividad(Actividad actividad){
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
    
    public List<Actividad> obtenerActividadesAlumno(String Alumno_clave){
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
    
    public List<Actividad> obtenerActividadesGrupo (Integer Grupo_idGrupo){
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
}
