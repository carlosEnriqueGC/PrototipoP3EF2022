/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsLinea;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoLinea {

    private static final String SQL_SELECT = "SELECT idl, nombrel, estadol FROM tbl_linea";
    private static final String SQL_INSERT = "INSERT INTO tbl_linea(nombrel, estadol) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_linea SET nombrel=?, estadol=? WHERE idl = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_linea WHERE idl=?";
    private static final String SQL_QUERY = "SELECT idl, nombrel, estadol FROM tbl_linea WHERE idl=?";
    private static final String SQL_QUERYN = "SELECT idl, nombrel, estadol FROM tbl_linea WHERE nombrel=?";    

    public List<clsLinea> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsLinea usuario = null;
        List<clsLinea> usuarios = new ArrayList<clsLinea>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idl");
                String nombre = rs.getString("nombrel");
                String estado = rs.getString("estadol");
                

                usuario = new clsLinea();
                usuario.setidl(id);
                usuario.setnombrel(nombre);
                usuario.setestadol(estado);
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

    public int insert(clsLinea usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombrel());
            stmt.setString(2, usuario.getestadol());
               

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

    public int update(clsLinea usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombrel());
            stmt.setString(2, usuario.getestadol());
               
            stmt.setInt(3, usuario.getidl());

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

    public int delete(clsLinea usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidl());
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

    public clsLinea query(clsLinea usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getidl());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("idl");
                String nombre = rs.getString("nombrel");
                String estado = rs.getString("estadol");
                

                usuario = new clsLinea();
                usuario.setidl(id);
                usuario.setnombrel(nombre);
                usuario.setestadol(estado);
                
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
public clsLinea queryn(clsLinea usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombrel());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("idl");
                String nombre = rs.getString("nombrel");
                String estado = rs.getString("estadol");
                

                usuario = new clsLinea();
                usuario.setidl(id);
                usuario.setnombrel(nombre);
                usuario.setestadol(estado);
                
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
