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
public class clsMantenimiento3 {
    int id3;
    String nombre3;
    String estado3;

            

    public clsMantenimiento3(int id) {
        this.id3 = id;
    }

    public clsMantenimiento3() {
    }

    public clsMantenimiento3(String nombre, String estado) {
        this.nombre3 = nombre;
        this.estado3 = estado;
         
    }

    public int getid3() {
        return id3;
    }

    public void setid3(int id) {
        this.id3 = id;
    }

    public String getnombre3() {
        return nombre3;
    }

    public void setnombre3(String nombre) {
        this.nombre3 = nombre;
    }

    public String getestado3() {
        return estado3;
    }

    public void setestado3(String estado) {
        this.estado3 = estado;
    }

    
    @Override
    public String toString() {
        return "tbl_mantenimiento3{" + "id3=" + id3 + ", nombre3=" + nombre3 + ", estado3=" + estado3 +'}';
    }
    

}