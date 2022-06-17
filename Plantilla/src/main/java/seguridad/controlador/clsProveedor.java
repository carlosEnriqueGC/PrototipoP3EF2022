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
public class clsProveedor {
    int idp;
    String nombrep;
    String direccionp;
    String telefonop;
    String nitp;
    String estadop;

            

    public clsProveedor(int id) {
        this.idp = id;
    }

    public clsProveedor() {
    }

    public clsProveedor(String nombre, String estado, String direccion, String nit, String telefono) {
        this.nombrep = nombre;
        this.direccionp = direccion;
        this.telefonop = telefono;
        this.nitp = nit;
        this.estadop = estado;
         
    }

    public int getidp() {
        return idp;
    }

    public void setidp(int id) {
        this.idp = id;
    }

    public String getnombrep() {
        return nombrep;
    }

    public void setnombrep(String nombre) {
        this.nombrep = nombre;
    }

    public String getdireccionp() {
        return direccionp;
    }

    public void setdireccionp(String direccion) {
        this.direccionp = direccion;
    }
    
    public String gettelefonop() {
        return telefonop;
    }

    public void settelefonop(String telefono) {
        this.telefonop = telefono;
    }
    
    public String getnitp() {
        return nitp;
    }

    public void setnitp(String nit) {
        this.nitp = nit;
    }
    
    public String getestadop() {
        return estadop;
    }

    public void setestadop(String estado) {
        this.estadop = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_proveeedor{" + "idp=" + idp + ", nombrep=" + nombrep +", direccionp=" + direccionp + ", telefonop="+ telefonop + ", nitp="+ nitp +", estadop=" + estadop +'}';
    }
    

}