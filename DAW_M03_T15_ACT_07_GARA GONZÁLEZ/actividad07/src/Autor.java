
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gara
 */
public class Autor {
    String nombre;
    String apellidos;
    int id;

public Autor( int id, String nombre, String apellidos){
    this.id = id;
    this.nombre = nombre;
    this.apellidos = apellidos;
     
    

}

    public Autor() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

@Override
    public String toString() {  
    return "id: " + this.id + " | Nombre: " + this.nombre + " | Apellidos: " + this.apellidos;
    }

}
