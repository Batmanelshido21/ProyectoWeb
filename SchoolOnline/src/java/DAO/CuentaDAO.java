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
import pojos.Docente;

/**
 *
 * @author javie
 */
public class CuentaDAO {

    public CuentaDAO() {
    }

    public Alumno loginAlumno(Cuenta cuenta) {
        Alumno alumno = new Alumno();
        String Cuenta_nombreUsuario;
        SqlSession conexion = MyBatisUtil.getSession();
        if (conexion != null) {
            try {
                Cuenta_nombreUsuario = conexion.selectOne("Cuenta.login", cuenta);

                if (Cuenta_nombreUsuario == null) {
                    alumno.setIdAlumno(0);
                    return alumno;
                } else {
                    alumno = conexion.selectOne("Cuenta.getAlumno", Cuenta_nombreUsuario);
                    if (alumno != null) {
                        conexion.commit();
                        return alumno;
                    } else {
                        alumno.setIdAlumno(0);
                        return alumno;
                    }
                }
            } finally {
                String j = conexion.toString();
                conexion.close();
            }
        }
        return alumno;
    }

    public Docente loginDocente(Cuenta cuenta) {
        Docente docente = new Docente();
        String Cuenta_nombreUsuario;
        SqlSession conexion = MyBatisUtil.getSession();
        if (conexion != null) {
            try {
                Cuenta_nombreUsuario = conexion.selectOne("Cuenta.login", cuenta);

                if (Cuenta_nombreUsuario == null) {
                    docente.setIdDocente(0);
                    return docente;
                } else {
                    docente = conexion.selectOne("Cuenta.getDocente", Cuenta_nombreUsuario);

                    if (docente != null) {
                        conexion.commit();
                        return docente;
                    } else {
                        docente.setIdDocente(0);
                        return docente;
                    }
                }
            } finally {
                String j = conexion.toString();
                conexion.close();
            }
        }
        return docente;
    }

    public boolean registrarAlumno(Cuenta cuenta, Alumno alumno) {

        SqlSession conexion = MyBatisUtil.getSession();
        if (conexion != null) {
            try {
                conexion.insert("Cuenta.registrarCuenta", cuenta);
                conexion.insert("Cuenta.registrarAlumno", alumno);
                conexion.commit();
                return true;
            } finally {
                String j = conexion.toString();
                conexion.close();
            }
        }
        return false;
    }

    public boolean registrarDocente(Cuenta cuenta, Docente docente) {
        SqlSession conexion = MyBatisUtil.getSession();
        if (conexion != null) {
            try {
                conexion.insert("Cuenta.registrarCuenta", cuenta);
                conexion.insert("Cuenta.registrarDocente", docente);
                conexion.commit();
                return true;
            } finally {
                String j = conexion.toString();
                conexion.close();
            }
        }
        return false;
    }

    public boolean modificarDocente(Docente docente) {
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

}
