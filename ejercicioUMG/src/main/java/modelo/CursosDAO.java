/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Cursos;
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
public class CursosDAO {
    
    private static final String SQL_SELECT = "SELECT curcodigo, curnombre,  curestatus FROM cursos";
    private static final String SQL_INSERT = "INSERT INTO cursos(curnombre,  curestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE cursos SET curnombre=?,  curestatus=? WHERE curcodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE curcodigo=?";
    private static final String SQL_QUERY = "SELECT curcodigo, curnombre,  curestatus FROM cursos WHERE curcodigo = ?";
    
    public List<Cursos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cursos curso = null;
        List<Cursos> Cursos = new ArrayList<Cursos>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoCurso = rs.getInt("curcodigo");
                String nombreCurso = rs.getString("curnombre");
                String statusCurso = rs.getString("curestatus");
                               
                curso = new Cursos();
                curso.setCodigoCurso(codigoCurso);
                curso.setNombreCur(nombreCurso);
                curso.setEstatusCur(statusCurso);
                                
                Cursos.add(curso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return Cursos;
    }
    
    public int insert(Cursos curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getNombreCur());
            stmt.setString(2, curso.getEstatusCur());
            
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
      
    public int update(Cursos curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, curso.getNombreCur());
            stmt.setString(2, curso.getEstatusCur());
            stmt.setInt(3, curso.getCodigoCurso());
            
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
     
    public int delete(Cursos curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, curso.getCodigoCurso());
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

    public Cursos query(Cursos curso) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cursos> Cursos = new ArrayList<Cursos>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, curso.getCodigoCurso());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoCurso = rs.getInt("curcodigo");
                String nombreCurso = rs.getString("curnombre");
                String statusCurso = rs.getString("curestatus");
                               
                curso = new Cursos();
                curso.setCodigoCurso(codigoCurso);
                curso.setNombreCur(nombreCurso);
                curso.setEstatusCur(statusCurso);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return curso;
    }
    
}