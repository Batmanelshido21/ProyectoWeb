/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Foro;
import pojos.Grupo;

/**
 *
 * @author javie
 */
public class GrupoDAO {

    public GrupoDAO() {
    }
    
    public List<Grupo> obtenerGrupodID(String clave){
         List<Grupo> list = null;
        SqlSession conexion = MyBatisUtil.getSession();
       
       if(conexion != null){
            try{
                list = conexion.selectList("Grupo.getGruposD",clave);
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
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }
    
}
