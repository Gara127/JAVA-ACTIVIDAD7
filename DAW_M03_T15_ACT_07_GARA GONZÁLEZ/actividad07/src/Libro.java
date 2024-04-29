/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gara
 */
public class Libro {

    String titulo;
    String autor;
    String pais;
    String genero;
    int paginas;
    int id;
    int autorId;

    public Libro( int id, String titulo, String autor, String pais, String genero, int paginas, int autorId){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.pais = pais;
        this.genero = genero;
        this.paginas = paginas;
        this.autorId = autorId;
     
    

    }

    @Override
        public String toString() {  // sobreescribimos elmétodo toString para poder mostrar facilmente los atributos de la clase Comida.
        return "id: " + this.id + " | titulo: " + this.titulo + " | autor: " + this.autor + " | pais: " + this.pais+ " | genero: " + this.genero+ " | paginas: " + this.paginas;
    }


}
