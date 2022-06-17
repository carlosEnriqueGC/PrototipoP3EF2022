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
public class clsCliente {
    int idc;
    String nombrec;
    String direccionc;
    String nitc;
    String telefonoc;
    String codivendec;
    String estadoc;

            

    public clsCliente(int id) {
        this.idc = id;
    }

    public clsCliente() {
    }

    public clsCliente(String nombre, String estado, String direccion, String nit, String telefono, String codigo) {
        this.nombrec = nombre;
        this.direccionc = direccion;
        this.nitc= nit;
        this.telefonoc=telefono;
        this.codivendec=codigo;
        this.estadoc = estado;
         
    }

    public int getidc() {
        return idc;
    }

    public void setidc(int id) {
        this.idc = id;
    }

    public String getnombrec() {
        return nombrec;
    }

    public void setnombrec(String nombre) {
        this.nombrec = nombre;
    }

    public String getdireccionc() {
        return direccionc;
    }

    public void setdireccionc(String direccion) {
        this.direccionc = direccion;
    }
    
     public String getnitc() {
        return nitc;
    }

    public void setnitc(String nit) {
        this.nitc = nit;
    }
    
    public String gettelefonoc() {
        return telefonoc;
    }

    public void settelefonoc(String telefono) {
        this.telefonoc = telefono;
    }
    
    public String getcodic() {
        return codivendec;
    }

    public void setcodic(String codigo) {
        this.codivendec = codigo;
    }
      public String getestadoc() {
        return estadoc;
    }

    public void setestadoc(String estado) {
        this.estadoc = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_cliente{" + "idc=" + idc + ", nombrec=" + nombrec + ", direccionc="+ direccionc +", nitc="+ nitc + ", telefonoc="+ telefonoc + ", codivendec="+ codivendec +", estadoc=" + estadoc +'}';
    }
    

}