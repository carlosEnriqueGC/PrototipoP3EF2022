/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsVenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoVenta {

    private static final String SQL_SELECT = "SELECT idven, productoven, valorpven, cantidadven, clienteven, valorven, bodegaven, vendeven FROM tbl_venta";
    private static final String SQL_INSERT = "INSERT INTO tbl_venta(productoven, valorpven, cantidadven, clienteven, valorven, bodegaven, vendeven) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_venta SET productoven=?, valorpven=?, cantidadven=?, clienteven=?, valorven=?, bodegaven=?, vendeven=?, WHERE idven = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_venta WHERE idven=?";
    private static final String SQL_QUERY = "SELECT idven, productoven, valorpven, cantidadven, clienteven, valorven, bodegaven, vendeven FROM tbl_venta WHERE idven=?";
    private static final String SQL_QUERYN = "SELECT idven, productoven, valorpven, cantidadven, clienteven, valorven, bodegaven, vendeven FROM tbl_venta WHERE productoven=?";    

    public List<clsVenta> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVenta usuario = null;
        List<clsVenta> usuarios = new ArrayList<clsVenta>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idven");
                String producto = rs.getString("productoven");
                String valorp = rs.getString("valorpven");
                String cantidad = rs.getString("cantidadven");
                String cliente = rs.getString("clienteven");
                String valor = rs.getString("valorven");
                String bodega = rs.getString("bodegaven");
                String vendedor = rs.getString("vendeven");
                

                usuario = new clsVenta();
                usuario.setidve(id);
                usuario.setproductove(producto);
                usuario.setvalorpve(valorp);
                usuario.setcantidadve(cantidad);
                usuario.setclienteve(cliente);
                usuario.setvalorve(valor);
                usuario.setbodegave(bodega);
                usuario.setvendedorve(vendedor);
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

    public int insert(clsVenta usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getproductove());
            stmt.setString(2, usuario.getvalorpve());
            stmt.setString(3, usuario.getcantidadve());
            stmt.setString(4, usuario.getclienteve());
            stmt.setString(5, usuario.getvalorve());
            stmt.setString(6, usuario.getbodegave());
            stmt.setString(7, usuario.getvendedorve());
            
               

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

    public int update(clsVenta usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getproductove());
            stmt.setString(2, usuario.getvalorpve());
            stmt.setString(3, usuario.getcantidadve());
            stmt.setString(4, usuario.getclienteve());
            stmt.setString(5, usuario.getvalorve());
            stmt.setString(6, usuario.getbodegave());
            stmt.setString(7, usuario.getvendedorve());
               
            stmt.setInt(8, usuario.getidve());

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

    public int delete(clsVenta usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidve());
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

    public clsVenta query(clsVenta usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getidve());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("idven");
                String producto = rs.getString("productoven");
                String valorp = rs.getString("valorpven");
                String cantidad = rs.getString("cantidadven");
                String cliente = rs.getString("clienteven");
                String valor = rs.getString("valorven");
                String bodega = rs.getString("bodegaven");
                String vendedor = rs.getString("vendeven");
                

                usuario = new clsVenta();
                usuario.setidve(id);
                usuario.setproductove(producto);
                usuario.setvalorpve(valorp);
                usuario.setcantidadve(cantidad);
                usuario.setclienteve(cliente);
                usuario.setvalorve(valor);
                usuario.setbodegave(bodega);
                usuario.setvendedorve(vendedor);
                
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
public clsVenta queryn(clsVenta usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getproductove());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                  int id = rs.getInt("idven");
                String producto = rs.getString("productoven");
                String valorp = rs.getString("valorpven");
                String cantidad = rs.getString("cantidadven");
                String cliente = rs.getString("clienteven");
                String valor = rs.getString("valorven");
                String bodega = rs.getString("bodegaven");
                String vendedor = rs.getString("vendeven");
                

                usuario = new clsVenta();
                usuario.setidve(id);
                usuario.setproductove(producto);
                usuario.setvalorpve(valorp);
                usuario.setcantidadve(cantidad);
                usuario.setclienteve(cliente);
                usuario.setvalorve(valor);
                usuario.setbodegave(bodega);
                usuario.setvendedorve(vendedor);
                
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
