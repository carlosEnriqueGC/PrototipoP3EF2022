/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsVendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoVendedor {

    private static final String SQL_SELECT = "SELECT idv, nombrev, direccionv, nitv, telefonov, estadov FROM tbl_vendedor";
    private static final String SQL_INSERT = "INSERT INTO tbl_vendedor(nombrev, direccionv, nitv, telefonov, estadov) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_vendedor SET nombrev=?, direccionv=?, nitv=?, telefonov=?, estadov=? WHERE idv = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_vendedor WHERE idv=?";
    private static final String SQL_QUERY = "SELECT idv, nombrev, direccionv, nitv, telefonov, estadov FROM tbl_vendedor WHERE idv=?";
    private static final String SQL_QUERYN = "SELECT idv, nombrev, direccionv, nitv, telefonov, estadov FROM tbl_vendedor WHERE nombrev=?";    

    public List<clsVendedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVendedor usuario = null;
        List<clsVendedor> usuarios = new ArrayList<clsVendedor>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idv");
                String nombre = rs.getString("nombrev");
                String direccion = rs.getString("direccionv");
                String nit = rs.getString("nitv");
                String telefono = rs.getString("telefonov");
                String estado = rs.getString("estadov");
                

                usuario = new clsVendedor();
                usuario.setidv(id);
                usuario.setnombrev(nombre);
                usuario.setdireccionv(direccion);
                usuario.setnitv(nit);
                usuario.settelefonov(telefono);
               
                usuario.setestadov(estado);
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

    public int insert(clsVendedor usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombrev());
             stmt.setString(2, usuario.getdireccionv());
              stmt.setString(3, usuario.getnitv());
               stmt.setString(4, usuario.gettelefonov());
                
                 stmt.setString(5, usuario.getestadov());
               

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

    public int update(clsVendedor usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setString(1, usuario.getnombrev());
             stmt.setString(2, usuario.getdireccionv());
              stmt.setString(3, usuario.getnitv());
               stmt.setString(4, usuario.gettelefonov());
                
                 stmt.setString(5, usuario.getestadov());   
                  stmt.setInt(6, usuario.getidv());

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

    public int delete(clsVendedor usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidv());
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

    public clsVendedor query(clsVendedor usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getidv());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
             int id = rs.getInt("idv");
                String nombre = rs.getString("nombrev");
                String direccion = rs.getString("direccionv");
                String nit = rs.getString("nitv");
                String telefono = rs.getString("telefonov");      
                String estado = rs.getString("estadov");
                

                usuario = new clsVendedor();
                usuario.setidv(id);
                usuario.setnombrev(nombre);
                usuario.setdireccionv(direccion);
                usuario.setnitv(nit);
                usuario.settelefonov(telefono);
             
                usuario.setestadov(estado);
                
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
public clsVendedor queryn(clsVendedor usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombrev());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
               int id = rs.getInt("idv");
                String nombre = rs.getString("nombrev");
                String direccion = rs.getString("direccionv");
                String nit = rs.getString("nitv");
                String telefono = rs.getString("telefonov");
                String estado = rs.getString("estadov");
                

                usuario = new clsVendedor();
                usuario.setidv(id);
                usuario.setnombrev(nombre);
                usuario.setdireccionv(direccion);
                usuario.setnitv(nit);
                usuario.settelefonov(telefono);
                
                usuario.setestadov(estado);
                
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
