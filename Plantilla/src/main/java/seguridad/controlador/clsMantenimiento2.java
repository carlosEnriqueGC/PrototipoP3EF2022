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
public class clsMantenimiento2 {
    int id2;
    String nombre2;
    String estado2;

            

    public clsMantenimiento2(int id) {
        this.id2 = id;
    }

    public clsMantenimiento2() {
    }

    public clsMantenimiento2(String nombre, String estado) {
        this.nombre2 = nombre;
        this.estado2 = estado;
         
    }

    public int getid2() {
        return id2;
    }

    public void setid2(int id) {
        this.id2 = id;
    }

    public String getnombre2() {
        return nombre2;
    }

    public void setnombre2(String nombre) {
        this.nombre2 = nombre;
    }

    public String getestado2() {
        return estado2;
    }

    public void setestado2(String estado) {
        this.estado2 = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_mantenimiento2{" + "id2=" + id2 + ", nombre2=" + nombre2 + ", estado2=" + estado2 +'}';
    }
    

}