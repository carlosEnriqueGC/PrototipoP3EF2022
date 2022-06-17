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
public class clsMantenimiento5 {
    int id5;
    String nombre5;
    String estado5;

            

    public clsMantenimiento5(int id) {
        this.id5 = id;
    }

    public clsMantenimiento5() {
    }

    public clsMantenimiento5(String nombre, String estado) {
        this.nombre5 = nombre;
        this.estado5 = estado;
         
    }

    public int getid5() {
        return id5;
    }

    public void setid5(int id) {
        this.id5 = id;
    }

    public String getnombre5() {
        return nombre5;
    }

    public void setnombre5(String nombre) {
        this.nombre5 = nombre;
    }

    public String getestado5() {
        return estado5;
    }

    public void setestado5(String estado) {
        this.estado5 = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_mantenimiento5{" + "id5=" + id5 + ", nombre5=" + nombre5 + ", estado5=" + estado5 +'}';
    }
    

}