/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsMantenimiento3;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMantenimiento3 {

    private static final String SQL_SELECT = "SELECT id3, nombre3, estado3 FROM tbl_mantenimiento3";
    private static final String SQL_INSERT = "INSERT INTO tbl_mantenimiento3(nombre3, estado3) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_mantenimiento3 SET nombre3=?, estado3=? WHERE id3 = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_mantenimiento3 WHERE id3=?";
    private static final String SQL_QUERY = "SELECT id3, nombre3, estado3 FROM tbl_mantenimiento3 WHERE id3=?";
    private static final String SQL_QUERYN = "SELECT id3, nombre3, estado3 FROM tbl_mantenimiento3 WHERE nombre3=?";    

    public List<clsMantenimiento3> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMantenimiento3 usuario = null;
        List<clsMantenimiento3> usuarios = new ArrayList<clsMantenimiento3>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id3");
                String nombre = rs.getString("nombre3");
                String estado = rs.getString("estado3");
                

                usuario = new clsMantenimiento3();
                usuario.setid3(id);
                usuario.setnombre3(nombre);
                usuario.setestado3(estado);
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

    public int insert(clsMantenimiento3 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombre3());
            stmt.setString(2, usuario.getestado3());
               

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

    public int update(clsMantenimiento3 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombre3());
            stmt.setString(2, usuario.getestado3());
               
            stmt.setInt(3, usuario.getid3());

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

    public int delete(clsMantenimiento3 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid3());
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

    public clsMantenimiento3 query(clsMantenimiento3 usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getid3());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("id3");
                String nombre = rs.getString("nombre3");
                String estado = rs.getString("estado3");
                

                usuario = new clsMantenimiento3();
                usuario.setid3(id);
                usuario.setnombre3(nombre);
                usuario.setestado3(estado);
                
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
public clsMantenimiento3 queryn(clsMantenimiento3 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombre3());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("id3");
                String nombre = rs.getString("nombre3");
                String estado = rs.getString("estado3");
                

                usuario = new clsMantenimiento3();
                usuario.setid3(id);
                usuario.setnombre3(nombre);
                usuario.setestado3(estado);
                
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
