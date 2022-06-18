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
public class clsVenta {
    int idven;
    String productoven;
    String valorpven;
    String cantidadven;
    String clienteven;
    String valorven;
    String bodegaven;
    String vendeven;
            

    public clsVenta(int id) {
        this.idven = id;
    }

    public clsVenta() {
    }

    public clsVenta(String nombre, String producto, String valorp, String cantidad, String cliente, String valor, String bodega, String vendedor ) {
        this.productoven = producto;
        this.valorpven = valorp;
        this.cantidadven = cantidad;
        this.clienteven = cliente;
        this.valorven = valor;
        this.bodegaven = bodega;
        this.vendeven = vendedor;
    }

    public int getidve() {
        return idven;
    }

    public void setidve(int id) {
        this.idven = id;
    }

    public String getproductove() {
        return productoven;
    }

    public void setproductove(String producto) {
        this.productoven = producto;
    }

    public String getvalorpve() {
        return valorpven;
    }

    public void setvalorpve(String  valorp) {
        this.valorpven = valorp;
    }
    
     public String getcantidadve() {
        return cantidadven;
    }

    public void setcantidadve(String  cantidad) {
        this.cantidadven = cantidad;
    }
    
     public String getclienteve() {
        return clienteven;
    }

    public void setclienteve(String  cliente) {
        this.clienteven = cliente;
    }
    
     public String getvalorve() {
        return valorven;
    }

    public void setvalorve(String  valor) {
        this.valorven = valor;
    }
    
     public String getbodegave() {
        return bodegaven;
    }

    public void setbodegave(String  bodega) {
        this.bodegaven = bodega;
    }
    
     public String getvendedorve() {
        return vendeven;
    }

    public void setvendedorve(String  vendedor) {
        this.vendeven = vendedor;
    }
    
    @Override
    public String toString() {
        return "tbl_venta{" + "idven=" + idven + ", productoven=" + productoven + ", valorpven=" + valorpven +", cantidadven="+cantidadven+", clienteven="+clienteven+", valorven="+valorven+", bodegaven="+bodegaven+", vendeven="+vendeven+'}';
    }
    

}