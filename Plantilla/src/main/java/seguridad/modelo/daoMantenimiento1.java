/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsMantenimiento1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMantenimiento1 {

    private static final String SQL_SELECT = "SELECT id1, nombre1, estado1 FROM tbl_mantenimiento1";
    private static final String SQL_INSERT = "INSERT INTO tbl_mantenimiento1(nombre1, estado1) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_mantenimiento1 SET nombre1=?, estado1=? WHERE id1 = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_mantenimiento1 WHERE id1=?";
    private static final String SQL_QUERY = "SELECT id1, nombre1, estado1 FROM tbl_mantenimiento1 WHERE id1=?";
    private static final String SQL_QUERYN = "SELECT id1, nombre1, estado1 FROM tbl_mantenimiento1 WHERE nombre1=?";    

    public List<clsMantenimiento1> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMantenimiento1 usuario = null;
        List<clsMantenimiento1> usuarios = new ArrayList<clsMantenimiento1>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id1");
                String nombre = rs.getString("nombre1");
                String estado = rs.getString("estado1");
                

                usuario = new clsMantenimiento1();
                usuario.setid1(id);
                usuario.setnombre1(nombre);
                usuario.setestado1(estado);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsMantenimiento1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombre1());
            stmt.setString(2, usuario.getestado1());
               

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsMantenimiento1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombre1());
            stmt.setString(2, usuario.getestado1());
               
            stmt.setInt(3, usuario.getid1());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsMantenimiento1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid1());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsMantenimiento1 query(clsMantenimiento1 usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getid1());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("id1");
                String nombre = rs.getString("nombre1");
                String estado = rs.getString("estado1");
                

                usuario = new clsMantenimiento1();
                usuario.setid1(id);
                usuario.setnombre1(nombre);
                usuario.setestado1(estado);
                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
public clsMantenimiento1 queryn(clsMantenimiento1 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombre1());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("id1");
                String nombre = rs.getString("nombre1");
                String estado = rs.getString("estado1");
                

                usuario = new clsMantenimiento1();
                usuario.setid1(id);
                usuario.setnombre1(nombre);
                usuario.setestado1(estado);
                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
    
}
