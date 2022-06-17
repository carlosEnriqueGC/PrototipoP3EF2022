/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsProveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProveedor {

    private static final String SQL_SELECT = "SELECT idp, nombrep, direccionp, telefonop, nitp, estadop FROM tbl_proveedor";
    private static final String SQL_INSERT = "INSERT INTO tbl_proveedor(nombrep, direccionp, telefonop, nitp, estadop) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_proveedor SET nombrep=?, direccionp=?, telefonop=?, nitp=?, estadop=? WHERE idp = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_proveedor WHERE idp=?";
    private static final String SQL_QUERY = "SELECT idp, nombrep, direccionp, telefonop, nitp, estadop FROM tbl_proveedor WHERE idp=?";
    private static final String SQL_QUERYN = "SELECT idp, nombrep, direccionp, telefonop, nitp, estadop FROM tbl_proveedor WHERE nombrep=?";    

    public List<clsProveedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProveedor usuario = null;
        List<clsProveedor> usuarios = new ArrayList<clsProveedor>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
               int id = rs.getInt("idp");
                String nombre = rs.getString("nombrep");
                String direccion = rs.getString("direccionp");
                String telefono = rs.getString("telefonop");
                String nit = rs.getString("nitp");
                String estado = rs.getString("estadop");
                

                usuario = new clsProveedor();
                usuario.setidp(id);
                usuario.setnombrep(nombre);
                usuario.setdireccionp(direccion);
                usuario.settelefonop(telefono);
                usuario.setnitp(nit);
                usuario.setestadop(estado);
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

    public int insert(clsProveedor usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombrep());
             stmt.setString(2, usuario.getdireccionp());
               stmt.setString(3, usuario.gettelefonop());
                stmt.setString(4, usuario.getnitp());
                 stmt.setString(5, usuario.getestadop());
               

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

    public int update(clsProveedor usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombrep());
             stmt.setString(2, usuario.getdireccionp());
               stmt.setString(3, usuario.gettelefonop());
                stmt.setString(4, usuario.getnitp());
                 stmt.setString(5, usuario.getestadop());   
                  stmt.setInt(6, usuario.getidp());

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

    public int delete(clsProveedor usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidp());
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

    public clsProveedor query(clsProveedor usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getidp());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
               int id = rs.getInt("idp");
                String nombre = rs.getString("nombrep");
                String direccion = rs.getString("direccionp");
                String telefono = rs.getString("telefonop");
                String nit = rs.getString("nitp");
                String estado = rs.getString("estadop");
                

                usuario = new clsProveedor();
                usuario.setidp(id);
                usuario.setnombrep(nombre);
                usuario.setdireccionp(direccion);
                usuario.settelefonop(telefono);
                usuario.setnitp(nit);
                usuario.setestadop(estado);
                
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
public clsProveedor queryn(clsProveedor usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombrep());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("idp");
                String nombre = rs.getString("nombrep");
                String direccion = rs.getString("direccionp");
                String telefono = rs.getString("telefonop");
                String nit = rs.getString("nitp");
                String estado = rs.getString("estadop");
                

                usuario = new clsProveedor();
                usuario.setidp(id);
                usuario.setnombrep(nombre);
                usuario.setdireccionp(direccion);
                usuario.settelefonop(telefono);
                usuario.setnitp(nit);
                usuario.setestadop(estado);
                
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
