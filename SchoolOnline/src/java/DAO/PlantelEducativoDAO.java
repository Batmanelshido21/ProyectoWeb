/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Cuenta;
import pojos.Docente;
import pojos.PlantelEducativo;

/**
 *
 * @author javie
 */
public class PlantelEducativoDAO {

    public PlantelEducativoDAO() {
    }

    public List<Docente> obtenerDocentes(String clave) {
        List<Docente> docente = null;
        SqlSession conexion = MyBatisUtil.getSession();

        if (conexion != null) {
            try {
                System.out.println("aqui");
                docente = conexion.selectList("Plantel.getDocente", clave);
                System.out.println("aqui");

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                String j = conexion.toString();
                conexion.close();
            }
        }
        return docente;
    }

    public boolean registrarPlantelEducativo(PlantelEducativo plantel, Cuenta cuenta) {
        SqlSession conexion = MyBatisUtil.getSession();

        if (conexion != null) {
            try {
                conexion.insert("Plantel.registrarPlantel", plantel);
                conexion.insert("Plantel.registrarCuenta", cuenta);
                conexion.commit();
                return true;
            } finally {
                String j = conexion.toString();
                conexion.close();
            }
        }
        return false;
    }

    public boolean modificarPlantelEducativo(PlantelEducativo plantel) {
        SqlSession conn = MyBatisUtil.getSession();

        try {
            conn.update("Plantel.modificarPlantel", plantel);
            conn.commit();
            return true;
        } catch (Exception ex) {

        } finally {
            conn.close();
        }

        return false;
    }

}
