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
public class clsMarca {
    int idm;
    String nombrem;
    String estadom;

            

    public clsMarca(int id) {
        this.idm = id;
    }

    public clsMarca() {
    }

    public clsMarca(String nombre, String estado) {
        this.nombrem = nombre;
        this.estadom = estado;
         
    }

    public int getidm() {
        return idm;
    }

    public void setidm(int id) {
        this.idm = id;
    }

    public String getnombrem() {
        return nombrem;
    }

    public void setnombrem(String nombre) {
        this.nombrem = nombre;
    }

    public String getestadom() {
        return estadom;
    }

    public void setestadom(String estado) {
        this.estadom = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_marca{" + "idm=" + idm + ", nombrem=" + nombrem + ", estadom=" + estadom +'}';
    }
    

}