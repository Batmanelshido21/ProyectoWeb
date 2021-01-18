/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Grupo;
import pojos.Mensaje;

/**
 *
 * @author javie
 */
public class ForoDAO {

    public ForoDAO() {
    }
    
    public boolean enviarMensaje(Mensaje mensajeO){
         SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Foro.enviarMensaje",mensajeO);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }
    
   
    public List<Mensaje> obtenerMensajes(Integer foro_idForo){
         List<Mensaje> list = null;
       SqlSession conexion = MyBatisUtil.getSession();
       
       if(conexion != null){
            try{
                list = conexion.selectList("Foro.getMensajesForo",foro_idForo);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list;
    }
    
    public Grupo obtenerForoId(Integer idGrupo) {
        SqlSession conexion = MyBatisUtil.getSession();
        Grupo grupo = new Grupo();
        if(conexion != null){
            try{
                grupo=conexion.selectOne("Foro.getIdForo",idGrupo);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return grupo;
    }
}
