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
public class clsVendedor {
    int idv;
    String nombrev;
    String direccionv;
    String nitv;
    String telefonov;
    String estadov;

            

    public clsVendedor(int id) {
        this.idv = id;
    }

    public clsVendedor() {
    }

    public clsVendedor(String nombre, String estado, String direccion, String nit, String telefono, String codigo) {
        this.nombrev = nombre;
        this.direccionv = direccion;
        this.nitv= nit;
        this.telefonov=telefono;
        
        this.estadov = estado;
         
    }

    public int getidv() {
        return idv;
    }

    public void setidv(int id) {
        this.idv = id;
    }

    public String getnombrev() {
        return nombrev;
    }

    public void setnombrev(String nombre) {
        this.nombrev = nombre;
    }

    public String getdireccionv() {
        return direccionv;
    }

    public void setdireccionv(String direccion) {
        this.direccionv = direccion;
    }
    
     public String getnitv() {
        return nitv;
    }

    public void setnitv(String nit) {
        this.nitv = nit;
    }
    
    public String gettelefonov() {
        return telefonov;
    }

    public void settelefonov(String telefono) {
        this.telefonov = telefono;
    }
    
      public String getestadov() {
        return estadov;
    }

    public void setestadov(String estado) {
        this.estadov = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_vendedor{" + "idv=" + idv + ", nombrev=" + nombrev + ", direccionv="+ direccionv +", nitv="+ nitv + ", telefonov="+ telefonov +", estadov=" + estadov +'}';
    }
    

}