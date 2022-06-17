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
public class clsBodega {
    int idb;
    String nombreb;
    String estadob;

            

    public clsBodega(int id) {
        this.idb = id;
    }

    public clsBodega() {
    }

    public clsBodega(String nombre, String estado) {
        this.nombreb = nombre;
        this.estadob = estado;
         
    }

    public int getidb() {
        return idb;
    }

    public void setidb(int id) {
        this.idb = id;
    }

    public String getnombreb() {
        return nombreb;
    }

    public void setnombreb(String nombre) {
        this.nombreb = nombre;
    }

    public String getestadob() {
        return estadob;
    }

    public void setestadob(String estado) {
        this.estadob = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_Bodega{" + "idb=" + idb + ", nombreb=" + nombreb + ", estadob=" + estadob +'}';
    }
    

}