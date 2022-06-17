/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsProductos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProducto {

    private static final String SQL_SELECT = "SELECT idpr, nombrepr, colineapr, comarcapr, estadopr, existenpr FROM tbl_productos";
    private static final String SQL_INSERT = "INSERT INTO tbl_productos(idpr, nombrepr, colineapr, comarcapr, estadopr, existenpr) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_productos SET nombrepr=?, colineapr=?, comarcapr=?,estadopr=?, existenpr=? WHERE idpr = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_productos WHERE idpr=?";
    private static final String SQL_QUERY = "SELECT idpr, nombrepr, colineapr, comarcapr, estadopr, existenpr FROM tbl_productos WHERE idpr=?";
    private static final String SQL_QUERYN = "SELECT idpr, nombrepr, colineapr, comarcapr, estadopr, existenpr FROM tbl_productos WHERE nombrepr=?";    

    public List<clsProductos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProductos usuario = null;
        List<clsProductos> usuarios = new ArrayList<clsProductos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idpr");
                String nombre = rs.getString("nombrepr");
                String linea = rs.getString("colineapr");
                String marca = rs.getString("comarcapr");
                String estado = rs.getString("estadopr");
                String existe = rs.getString("existenpr");
                

                usuario = new clsProductos();
                usuario.setidpr(id);
                usuario.setnombrepr(nombre);
                usuario.setcolineapr(linea);
                usuario.setcomarcapr(marca);
                usuario.setestadopr(estado);
                usuario.setexistenpr(existe);
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

    public int insert(clsProductos usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombrepr());
            stmt.setString(2, usuario.getcolineapr());
            stmt.setString(3, usuario.getcomarcapr());
            stmt.setString(4, usuario.getestadopr());
            stmt.setString(5, usuario.getexistenpr());
               

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

    public int update(clsProductos usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombrepr());
            stmt.setString(2, usuario.getcolineapr());
            stmt.setString(3, usuario.getcomarcapr());
            stmt.setString(4, usuario.getestadopr());
            stmt.setString(5, usuario.getexistenpr());
               
            stmt.setInt(6, usuario.getidpr());

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

    public int delete(clsProductos usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidpr());
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

    public clsProductos query(clsProductos usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getidpr());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                 int id = rs.getInt("idpr");
                String nombre = rs.getString("nombrepr");
                String linea = rs.getString("colineapr");
                String marca = rs.getString("comarcapr");
                String estado = rs.getString("estadopr");
                String existe = rs.getString("existenpr");
                

                usuario = new clsProductos();
                usuario.setidpr(id);
                usuario.setnombrepr(nombre);
                usuario.setcolineapr(linea);
                usuario.setcomarcapr(marca);
                usuario.setestadopr(estado);
                usuario.setexistenpr(existe);
                
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
public clsProductos queryn(clsProductos usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombrepr());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
             int id = rs.getInt("idpr");
                String nombre = rs.getString("nombrepr");
                String linea = rs.getString("colineapr");
                String marca = rs.getString("comarcapr");
                String estado = rs.getString("estadopr");
                String existe = rs.getString("existenpr");
                

                usuario = new clsProductos();
                usuario.setidpr(id);
                usuario.setnombrepr(nombre);
                usuario.setcolineapr(linea);
                usuario.setcomarcapr(marca);
                usuario.setestadopr(estado);
                usuario.setexistenpr(existe);
                
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
