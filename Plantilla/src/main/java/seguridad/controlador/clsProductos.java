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
public class clsProductos {
     int idpr;
    String nombrepr;
    String colineapr;
    String comarcapr;
    String estadopr;
    String existenpr;
    String valorpr;
            

    public clsProductos(int id) {
        this.idpr = id;
    }

    public clsProductos() {
    }

    public clsProductos(String nombre, String estado, String colinea, String comarca, String existen, String valor) {
        this.nombrepr = nombre;
        this.colineapr = colinea;
        this.comarcapr = comarca;
        this.estadopr = estado;
        this.existenpr = existen;
        this.valorpr = valor; 
    }

    public int getidpr() {
        return idpr;
    }

    public void setidpr(int id) {
        this.idpr = id;
    }

    public String getnombrepr() {
        return nombrepr;
    }

    public void setnombrepr(String nombre) {
        this.nombrepr = nombre;
    }

      public String getcolineapr() {
        return colineapr;
    }

    public void setcolineapr(String colinea) {
        this.colineapr = colinea;
    }
    
      public String getcomarcapr() {
        return comarcapr;
    }

    public void setcomarcapr(String comarca) {
        this.comarcapr = comarca;
    }
    
    public String getestadopr() {
        return estadopr;
    }

    public void setestadopr(String estado) {
        this.estadopr = estado;
    }
    
     public String getexistenpr() {
        return existenpr;
    }

    public void setexistenpr(String existen) {
        this.existenpr = existen;
    }
    
     public String getvalorpr() {
        return valorpr;
    }

    public void setvalorpr(String valor) {
        this.valorpr = valor;
    }
    
    @Override
    public String toString() {
       return "tbl_productos{" + "idpr=" + idpr + ", nombrepr=" + nombrepr + ", colineapr="+ colineapr +", comarcapr="+ comarcapr + ", estadopr="+ estadopr + ", existenpr="+ existenpr + ", valorpr="+ valorpr+'}';
    }
    

}