/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Modelo.Conexion;
import controlador.Jornadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mishel
 */
public class JornadasDAO {
    private static final String SQL_SELECT = "SELECT jorcodigo, jornombre FROM jornadas";
    private static final String SQL_INSERT = "INSERT INTO jornadas(jornombre) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE jornadas SET jornombre=? WHERE jorcodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM jornadas WHERE jorcodigo=?";
    private static final String SQL_QUERY = "SELECT curcodigo, jorcodigo FROM jornadas WHERE curcodigo = ?";
    
    public List<Jornadas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jornadas jornada = null;
        List<Jornadas> jornadas = new ArrayList<Jornadas>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoJornada = rs.getInt("jorcodigo");
                String nombreCurso = rs.getString("jornombre");
                               
                jornada = new Jornadas();
                jornada.setCodigoJornada(codigoJornada);
                jornada.setNombreJor(nombreCurso);
                                
                jornadas.add(jornada);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return jornadas;
    }
    
    public int insert(Jornadas jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, jornada.getNombreJor());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
      
    public int update(Jornadas jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, jornada.getNombreJor());
            stmt.setInt(2, jornada.getCodigoJornada());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
     
    public int delete(Jornadas jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, jornada.getCodigoJornada());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Jornadas query(Jornadas jornada) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Jornadas> jornadas = new ArrayList<Jornadas>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, jornada.getCodigoJornada());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoJornada = rs.getInt("jorcodigo");
                String nombreCurso = rs.getString("jornombre");
                               
                jornada = new Jornadas();
                jornada.setCodigoJornada(codigoJornada);
                jornada.setNombreJor(nombreCurso);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return jornada;
    }

    
}
