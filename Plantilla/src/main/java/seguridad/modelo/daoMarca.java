/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsMarca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMarca {

    private static final String SQL_SELECT = "SELECT idm, nombrem, estadom FROM tbl_marca";
    private static final String SQL_INSERT = "INSERT INTO tbl_marca(nombrem, estadom) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_marca SET nombrem=?, estadom=? WHERE idm = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_marca WHERE idm=?";
    private static final String SQL_QUERY = "SELECT idm, nombrem, estadom FROM tbl_marca WHERE idm=?";
    private static final String SQL_QUERYN = "SELECT idm, nombrem, estadom FROM tbl_marca WHERE nombrem=?";    

    public List<clsMarca> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsMarca usuario = null;
        List<clsMarca> usuarios = new ArrayList<clsMarca>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idm");
                String nombre = rs.getString("nombrem");
                String estado = rs.getString("estadom");
                

                usuario = new clsMarca();
                usuario.setidm(id);
                usuario.setnombrem(nombre);
                usuario.setestadom(estado);
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

    public int insert(clsMarca usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombrem());
            stmt.setString(2, usuario.getestadom());
               

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

    public int update(clsMarca usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombrem());
            stmt.setString(2, usuario.getestadom());
               
            stmt.setInt(3, usuario.getidm());

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

    public int delete(clsMarca usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidm());
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

    public clsMarca query(clsMarca usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getidm());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("idm");
                String nombre = rs.getString("nombrem");
                String estado = rs.getString("estadom");
                

                usuario = new clsMarca();
                usuario.setidm(id);
                usuario.setnombrem(nombre);
                usuario.setestadom(estado);
                
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
public clsMarca queryn(clsMarca usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombrem());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("idm");
                String nombre = rs.getString("nombrem");
                String estado = rs.getString("estadom");
                

                usuario = new clsMarca();
                usuario.setidm(id);
                usuario.setnombrem(nombre);
                usuario.setestadom(estado);
                
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
