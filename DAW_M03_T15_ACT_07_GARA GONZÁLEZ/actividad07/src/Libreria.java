

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class Libreria {
    
    public static void main(String[] args) throws IOException, Exception {
        int opcion = 0;
        Scanner entrada = new Scanner(System.in);
        BBDD_Connection bbdd = new BBDD_Connection();
        do {
            System.out.println();
            System.out.println("Quieres hacer alguna operación?");
            System.out.println("1. Restablecer la base de datos");
            System.out.println("2. Mostrar autores");
            System.out.println("3. Mostrar libros");
            System.out.println("4. Mostrar modificar un autor");
            System.out.println("5. Eliminar un libro");
            System.out.println("0. Salir");

            opcion = Pregunta.pideEntero("Introduzca la operación que desea realizar: ", entrada);
            bbdd.crearBDD (); // para la primera vez que se cree no dé error al no poder borrarBBDD
            switch (opcion) {
                case 1:
                    bbdd.borrarBDD();
                    bbdd.crearBDD ();    
                    bbdd.crearTablaAutor();
                    bbdd.crearTablaLibro();
                    bbdd.insertarDatos("Patrick", "Rothfuss");
                    bbdd.insertarDatos("George RR", "Martin");
                    bbdd.insertarLibros("El nombre del viento", "Patrick Rothfuss", "EE.UU", "Fantasia", 613,1);
                    bbdd.insertarLibros("Fuego y Sangre", "George RR Martin", "EE.UU", "Fantasia", 880,2); 

                    break;
                case 2:
                    bbdd.mostrarAutores();
                    break;
                    case 3:
                    bbdd.mostrarLibros();
                    break;
                case 4:
                    bbdd.modificarAutor(entrada);
                    break;  
                case 5:
                    bbdd.eliminarLibro(entrada);
                case 0:
                    System.out.println("Adiós!! :)");
                    System.out.println();
                    break;
                default:
                    System.out.println("Ha introducido un valor incorrecto, por favor inserte de nuevo");
                    System.out.println();
            }

        } while (opcion != 0);        



    }
}