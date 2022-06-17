/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsMantenimiento5;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMantenimiento5 {

    private static final String SQL_SELECT = "SELECT id5, nombre5, estado5 FROM tbl_mantenimiento5";
    private static final String SQL_INSERT = "INSERT INTO tbl_mantenimiento5(nombre5, estado5) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_mantenimiento5 SET nombre5=?, estado5=? WHERE id5 = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_mantenimiento5 WHERE id1=?";
    private static final String SQL_QUERY = "SELECT id5, nombre5, estado5 FROM tbl_mantenimiento5 WHERE id5=?";
    private static final String SQL_QUERYN = "SELECT id5, nombre5, estado5 FROM tbl_mantenimiento5 WHERE nombre5=?";    

    public List<clsMantenimiento5> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMantenimiento5 usuario = null;
        List<clsMantenimiento5> usuarios = new ArrayList<clsMantenimiento5>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id5");
                String nombre = rs.getString("nombre5");
                String estado = rs.getString("estado5");
                

                usuario = new clsMantenimiento5();
                usuario.setid5(id);
                usuario.setnombre5(nombre);
                usuario.setestado5(estado);
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

    public int insert(clsMantenimiento5 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombre5());
            stmt.setString(2, usuario.getestado5());
               

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

    public int update(clsMantenimiento5 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombre5());
            stmt.setString(2, usuario.getestado5());
               
            stmt.setInt(3, usuario.getid5());

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

    public int delete(clsMantenimiento5 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid5());
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

    public clsMantenimiento5 query(clsMantenimiento5 usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getid5());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("id5");
                String nombre = rs.getString("nombre5");
                String estado = rs.getString("estado5");
                

                usuario = new clsMantenimiento5();
                usuario.setid5(id);
                usuario.setnombre5(nombre);
                usuario.setestado5(estado);
                
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
public clsMantenimiento5 queryn(clsMantenimiento5 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombre5());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("id5");
                String nombre = rs.getString("nombre5");
                String estado = rs.getString("estado5");
                

                usuario = new clsMantenimiento5();
                usuario.setid5(id);
                usuario.setnombre5(nombre);
                usuario.setestado5(estado);
                
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
