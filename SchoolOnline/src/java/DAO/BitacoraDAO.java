/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Bitacora;

/**
 *
 * @author javie
 */
public class BitacoraDAO {

    public BitacoraDAO() {
    }
    
    public boolean registrarBitacora(Bitacora bitacora){
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Bitacora.registrarBitacora",bitacora);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        return false;
    }
    
    public boolean modificarBitacora(Bitacora bitacora){
        SqlSession conexion = MyBatisUtil.getSession();
        
        if(conexion != null){
            try{
                conexion.update("Bitacora.modificarBitacora",bitacora);
                conexion.commit();
                return true;
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }      
        
        return false;
    }
    
    public List<Bitacora> getBitacoras(String clave){
        List<Bitacora> list = null;
        SqlSession conexion = MyBatisUtil.getSession();
       
       if(conexion != null){
            try{
                list = conexion.selectList("Bitacora.getBitacoraDocente",clave);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        return list; 
    }
}
