/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.controlador;

/**
 *
 * @author visitante
 */
public class clsLinea {
    int idl;
    String nombrel;
    String estadol;

            

    public clsLinea(int id) {
        this.idl = id;
    }

    public clsLinea() {
    }

    public clsLinea(String nombre, String estado) {
        this.nombrel = nombre;
        this.estadol = estado;
         
    }

    public int getidl() {
        return idl;
    }

    public void setidl(int id) {
        this.idl = id;
    }

    public String getnombrel() {
        return nombrel;
    }

    public void setnombrel(String nombre) {
        this.nombrel = nombre;
    }

    public String getestadol() {
        return estadol;
    }

    public void setestadol(String estado) {
        this.estadol = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_linea{" + "idl=" + idl + ", nombrel=" + nombrel + ", estadol=" + estadol +'}';
    }
    

}