/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsMantenimiento2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMantenimiento2 {

    private static final String SQL_SELECT = "SELECT id2, nombre2, estado2 FROM tbl_mantenimiento2";
    private static final String SQL_INSERT = "INSERT INTO tbl_mantenimiento2(nombre2, estado2) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_mantenimiento2 SET nombre2=?, estado2=? WHERE id2 = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_mantenimiento2 WHERE id2=?";
    private static final String SQL_QUERY = "SELECT id2, nombre2, estado2 FROM tbl_mantenimiento2 WHERE id2=?";
    private static final String SQL_QUERYN = "SELECT id2, nombre2, estado2 FROM tbl_mantenimiento2 WHERE nombre2=?";    

    public List<clsMantenimiento2> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMantenimiento2 usuario = null;
        List<clsMantenimiento2> usuarios = new ArrayList<clsMantenimiento2>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id2");
                String nombre = rs.getString("nombre2");
                String estado = rs.getString("estado2");
                

                usuario = new clsMantenimiento2();
                usuario.setid2(id);
                usuario.setnombre2(nombre);
                usuario.setestado2(estado);
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

    public int insert(clsMantenimiento2 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombre2());
            stmt.setString(2, usuario.getestado2());
               

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

    public int update(clsMantenimiento2 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombre2());
            stmt.setString(2, usuario.getestado2());
               
            stmt.setInt(3, usuario.getid2());

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

    public int delete(clsMantenimiento2 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid2());
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

    public clsMantenimiento2 query(clsMantenimiento2 usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getid2());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("id2");
                String nombre = rs.getString("nombre2");
                String estado = rs.getString("estado2");
                

                usuario = new clsMantenimiento2();
                usuario.setid2(id);
                usuario.setnombre2(nombre);
                usuario.setestado2(estado);
                
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
public clsMantenimiento2 queryn(clsMantenimiento2 usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombre2());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("id2");
                String nombre = rs.getString("nombre2");
                String estado = rs.getString("estado2");
                

                usuario = new clsMantenimiento2();
                usuario.setid2(id);
                usuario.setnombre2(nombre);
                usuario.setestado2(estado);
                
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
