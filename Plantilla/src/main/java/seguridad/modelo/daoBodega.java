/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsBodega;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoBodega {

    private static final String SQL_SELECT = "SELECT idb, nombreb, estadob FROM tbl_bodega";
    private static final String SQL_INSERT = "INSERT INTO tbl_bodega(nombreb, estadob) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bodega SET nombreb=?, estadob=? WHERE idb = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_bodega WHERE idb=?";
    private static final String SQL_QUERY = "SELECT idb, nombreb, estadob FROM tbl_bodega WHERE idb=?";
    private static final String SQL_QUERYN = "SELECT idb, nombreb, estadob FROM tbl_bodega WHERE nombreb=?";    

    public List<clsBodega> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsBodega usuario = null;
        List<clsBodega> usuarios = new ArrayList<clsBodega>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idb");
                String nombre = rs.getString("nombreb");
                String estado = rs.getString("estadob");
                

                usuario = new clsBodega();
                usuario.setidb(id);
                usuario.setnombreb(nombre);
                usuario.setestadob(estado);
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

    public int insert(clsBodega usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnombreb());
            stmt.setString(2, usuario.getestadob());
               

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

    public int update(clsBodega usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnombreb());
            stmt.setString(2, usuario.getestadob());
               
            stmt.setInt(3, usuario.getidb());

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

    public int delete(clsBodega usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getidb());
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

    public clsBodega query(clsBodega usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getidb());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                int id = rs.getInt("idb");
                String nombre = rs.getString("nombreb");
                String estado = rs.getString("estadob");
                

                usuario = new clsBodega();
                usuario.setidb(id);
                usuario.setnombreb(nombre);
                usuario.setestadob(estado);
                
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
public clsBodega queryn(clsBodega usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnombreb());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("idb");
                String nombre = rs.getString("nombreb");
                String estado = rs.getString("estadob");
                

                usuario = new clsBodega();
                usuario.setidb(id);
                usuario.setnombreb(nombre);
                usuario.setestadob(estado);
                
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
