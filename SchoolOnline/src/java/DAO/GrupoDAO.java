/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
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
    
    public int crearGrupo(Foro foro, Grupo grupo){
         SqlSession conexion = MyBatisUtil.getSession();
         
         int idForo = 0;
         int idGrupo = 0; 
       
        if(conexion != null){
            try{
                conexion.insert("Grupo.registrarForo",foro);                
                idForo = conexion.selectOne("Grupo.getForo", grupo.getNombre());
                
                grupo.setForo_idForo(idForo);
                conexion.insert("Grupo.registrarGrupo",grupo);
                
                idGrupo = conexion.selectOne("Grupo.getGrupoRegistrado", idForo);
                conexion.commit();
                
                return idGrupo;
            }
            catch(Exception e){
                System.out.println(e);
            }finally{
                String j = conexion.toString();
                conexion.close();
            }
        }
        
        return idGrupo;
    }

     public List<Actividad> getActividadesAlumno(Integer idGrupo) {
        SqlSession conexion = MyBatisUtil.getSession();
        
        List<Actividad> list = null;
        try {
            list = conexion.selectList("Grupo.getActividadesGrupo",idGrupo);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

     public List<Grupo> getGruposAlumno(Integer Alumno_idAlumno) {
        SqlSession conexion = MyBatisUtil.getSession();
        List<Integer> lista = null;
        List<Grupo> listaGrupos = new ArrayList<Grupo>();
        Grupo grupo;

        try {
            lista = conexion.selectList("Grupo.getGrupoAlumno", Alumno_idAlumno);

            for (Integer g : lista) {
                grupo = conexion.selectOne("Grupo.getGruposDeAlumno", g);
                listaGrupos.add(grupo);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return listaGrupos;
    }
}
