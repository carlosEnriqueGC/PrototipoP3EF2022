/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCliente {

    private static final String SQL_SELECT = "SELECT idc, nombrec, direccionc, nitc, telefonoc, codivendec, estadoc FROM tbl_cliente";
    private static final String SQL_INSERT = "INSERT INTO tbl_cliente(nombrec, direccionc, nitc, telefonoc, codivendec, estadoc) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cliente SET nombrec=?, direccionc=?, nitc=?, telefonoc=?, codivendec=?, estadoc=? WHERE idc = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cliente WHERE idc=?";
    private static final String SQL_QUERY = "SELECT idc, nombrec, direccionc, nitc, telefonoc, codivendec, estadoc FROM tbl_cliente WHERE idc=?";
    private static final String SQL_QUERYN = "SELECT idc, nombrec, direccionc, nitc, telefonoc, codivendec, estadoc FROM tbl_cliente WHERE nombrec=?";    

    public List<clsCliente> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCliente usuario = null;
        List<clsCliente> usuarios = new ArrayList<clsCliente>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idc");
                String nombre = rs.getString("nombrec");
                String direccion = rs.getString("direccionc");
                String nit = rs.getString("nitc");
                String telefono = rs.getString("telefonoc");
                String codigo = rs.getString("codivendec");
                String estado = rs.getString("estadoc");
                

                usuario = new clsCliente();
                usuario.setidc(id);
                usuario.setnombrec(nombre);
                usuario.setdireccionc(direccion);
                usuario.setnitc(nit);
                usuario.settelefonoc(telefono);
                usuario.setcodic(codigo);
                usuario.setestadoc(estado);
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

    public int insert(clsCliente usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombrec());
             stmt.setString(2, usuario.getdireccionc());
              stmt.setString(3, usuario.getnitc());
               stmt.setString(4, usuario.gettelefonoc());
                stmt.setString(5, usuario.getcodic());
                 stmt.setString(6, usuario.getestadoc());
               

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

    public int update(clsCliente usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setString(1, usuario.getnombrec());
             stmt.setString(2, usuario.getdireccionc());
              stmt.setString(3, usuario.getnitc());
               stmt.setString(4, usuario.gettelefonoc());
                stmt.setString(5, usuario.getcodic());
                 stmt.setString(6, usuario.getestadoc());   
                  stmt.setInt(7, usuario.getidc());

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

    public int delete(clsCliente usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidc());
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

    public clsCliente query(clsCliente usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getidc());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
             int id = rs.getInt("idc");
                String nombre = rs.getString("nombrec");
                String direccion = rs.getString("direccionc");
                String nit = rs.getString("nitc");
                String telefono = rs.getString("telefonoc");
                String codigo = rs.getString("codivendec");
                String estado = rs.getString("estadoc");
                

                usuario = new clsCliente();
                usuario.setidc(id);
                usuario.setnombrec(nombre);
                usuario.setdireccionc(direccion);
                usuario.setnitc(nit);
                usuario.settelefonoc(telefono);
                usuario.setcodic(codigo);
                usuario.setestadoc(estado);
                
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
public clsCliente queryn(clsCliente usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombrec());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
               int id = rs.getInt("idc");
                String nombre = rs.getString("nombrec");
                String direccion = rs.getString("direccionc");
                String nit = rs.getString("nitc");
                String telefono = rs.getString("telefonoc");
                String codigo = rs.getString("codivendec");
                String estado = rs.getString("estadoc");
                

                usuario = new clsCliente();
                usuario.setidc(id);
                usuario.setnombrec(nombre);
                usuario.setdireccionc(direccion);
                usuario.setnitc(nit);
                usuario.settelefonoc(telefono);
                usuario.setcodic(codigo);
                usuario.setestadoc(estado);
                
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
