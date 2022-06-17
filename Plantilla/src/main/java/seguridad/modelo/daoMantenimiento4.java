/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsMantenimiento4;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMantenimiento4 {

    private static final String SQL_SELECT = "SELECT id4, nombre4, estado4 FROM tbl_mantenimiento4";
    private static final String SQL_INSERT = "INSERT INTO tbl_mantenimiento4(nombre4, estado4) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_mantenimiento4 SET nombre4=?, estado4=? WHERE id4 = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_mantenimiento4 WHERE id4=?";
    private static final String SQL_QUERY = "SELECT id4, nombre4, estado4 FROM tbl_mantenimiento4 WHERE id4=?";
    private static final String SQL_QUERYN = "SELECT id4, nombre4, estado4 FROM tbl_mantenimiento4 WHERE nombre4=?";    

    public List<clsMantenimiento4> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMantenimiento4 usuario = null;
        List<clsMantenimiento4> usuarios = new ArrayList<clsMantenimiento4>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id4");
                String nombre = rs.getString("nombre4");
                String estado = rs.getString("estado4");
                

                usuario = new clsMantenimiento4();
                usuario.setid4(id);
                usuario.setnombre4(nombre);
                usuario.setestado4(estado);
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

    public int insert(clsMantenimiento4 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombre4());
            stmt.setString(2, usuario.getestado4());
               

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

    public int update(clsMantenimiento4 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombre4());
            stmt.setString(2, usuario.getestado4());
               
            stmt.setInt(3, usuario.getid4());

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

    public int delete(clsMantenimiento4 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid4());
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

    public clsMantenimiento4 query(clsMantenimiento4 usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getid4());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("id4");
                String nombre = rs.getString("nombre4");
                String estado = rs.getString("estado4");
                

                usuario = new clsMantenimiento4();
                usuario.setid4(id);
                usuario.setnombre4(nombre);
                usuario.setestado4(estado);
                
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
public clsMantenimiento4 queryn(clsMantenimiento4 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombre4());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("id4");
                String nombre = rs.getString("nombre4");
                String estado = rs.getString("estado4");
                

                usuario = new clsMantenimiento4();
                usuario.setid4(id);
                usuario.setnombre4(nombre);
                usuario.setestado4(estado);
                
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
