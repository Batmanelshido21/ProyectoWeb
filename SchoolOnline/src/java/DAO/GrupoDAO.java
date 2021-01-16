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
import pojos.Foro;
import pojos.Grupo;

/**
 *
 * @author javie
 */
public class GrupoDAO {

    public GrupoDAO() {
    }
    
    public List<Grupo> obtenerGrupodID(Integer Docente_idDocente){
         List<Grupo> list = null;
        SqlSession conexion = MyBatisUtil.getSession();
       
       if(conexion != null){
            try{
                list = conexion.selectList("Grupo.getGruposD",Docente_idDocente);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
    }
    
    public boolean modificarGrupo(Grupo grupo){
        SqlSession conn = MyBatisUtil.getSession();
        
         try {
            conn.update("Grupo.modificarGrupo",grupo);
            conn.commit();
            return true;
        } catch (Exception ex) {
            
        } finally {
            conn.close();
        }
        
        return false;  
    }
    
    public boolean crearGrupo(Foro foro, Grupo grupo){
         SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.insert("Grupo.registrarForo",foro);
                conexion.insert("Grupo.registrarGrupo",grupo);
                conexion.commit();
                return true;
            }
            catch(Exception e){
                System.out.println(e);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }

    public List<Actividad> getActividadesAlumno(Integer Alumno_idAlumno) {
        SqlSession conexion = MyBatisUtil.getSession();
        Integer Grupo_idGrupo;
        List<Actividad> list = null;
        try{
            System.out.println("Antes de entrar al método");
            Grupo_idGrupo = conexion.selectOne("Grupo.getGrupoAlumno",Alumno_idAlumno);
            System.out.println(Grupo_idGrupo);
            list = conexion.selectList("Grupo.getActividadesGrupo",Grupo_idGrupo);
            System.out.println("Despues de entrar al método");
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
}
