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
public class clsMantenimiento1 {
    int id1;
    String nombre1;
    String estado1;

            

    public clsMantenimiento1(int id) {
        this.id1 = id;
    }

    public clsMantenimiento1() {
    }

    public clsMantenimiento1(String nombre, String estado) {
        this.nombre1 = nombre;
        this.estado1 = estado;
         
    }

    public int getid1() {
        return id1;
    }

    public void setid1(int id) {
        this.id1 = id;
    }

    public String getnombre1() {
        return nombre1;
    }

    public void setnombre1(String nombre) {
        this.nombre1 = nombre;
    }

    public String getestado1() {
        return estado1;
    }

    public void setestado1(String estado) {
        this.estado1 = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_mantenimiento1{" + "id1=" + id1 + ", nombre1=" + nombre1 + ", estado1=" + estado1 +'}';
    }
    

}