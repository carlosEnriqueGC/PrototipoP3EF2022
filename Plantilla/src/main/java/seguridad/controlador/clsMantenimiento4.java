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
public class clsMantenimiento4 {
    int id4;
    String nombre4;
    String estado4;

            

    public clsMantenimiento4(int id) {
        this.id4 = id;
    }

    public clsMantenimiento4() {
    }

    public clsMantenimiento4(String nombre, String estado) {
        this.nombre4 = nombre;
        this.estado4 = estado;
         
    }

    public int getid4() {
        return id4;
    }

    public void setid4(int id) {
        this.id4 = id;
    }

    public String getnombre4() {
        return nombre4;
    }

    public void setnombre4(String nombre) {
        this.nombre4 = nombre;
    }

    public String getestado4() {
        return estado4;
    }

    public void setestado4(String estado) {
        this.estado4 = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_mantenimiento4{" + "id4=" + id4 + ", nombre4=" + nombre4 + ", estado4=" + estado4 +'}';
    }
    

}