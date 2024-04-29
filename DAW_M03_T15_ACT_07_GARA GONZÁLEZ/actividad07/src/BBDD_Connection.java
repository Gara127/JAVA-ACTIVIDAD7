

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gara
 */
public class BBDD_Connection {
    	
    private static String datosConexion = "jdbc:mysql://localhost:3306/";   // datos de conexión con la base de datos
	private static String baseDatos = "librosBBDD";
	private static String usuario = "root";
	private static String password = "";
	private Connection con;
        
    public BBDD_Connection() throws Exception{
     try {
        con = DriverManager.getConnection(datosConexion, usuario, password); // nos conectamos a mysql
	
        
    }catch (SQLException e) {
        e.printStackTrace();
     }
    
        }

    public void crearBDD () throws SQLException { // nos conectamos a la base de datos
        String query = "create database if not exists "+ baseDatos +";";
        Statement stmt = null;
        
        try{
            stmt = con.createStatement(); // crear conexión a base de datos
            stmt.executeUpdate(query); // ejecutamos la query. Si existe la base de datos existe
            con = DriverManager.getConnection(datosConexion+baseDatos, usuario, password); // el conecction de mysql lo redirigimos a la base de datos
             System.out.println("Se ha creado correctamente la base de datos");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error al crear la base de datos");
        }finally{
            stmt.close();
        }
    }
    
    public void crearTablaLibro() throws Exception {
        String query = "create table if not exists Libro("
			+ "id int primary key auto_increment, " //clave principal para identificar el registro de la tabla.
			+ "titulo varchar(100), "
                        + "autor varchar(100), "
                        + "pais varchar(100), "
                        + "genero varchar(100), "
                        + "paginas int, "
                        + "autorId int, "
                        + "constraint fk_autor foreign key (autorId) references Autor(id));"; // clave foranea para vincularla con la tabla Autor

        Statement stmt = null;
        try{
            stmt = con.createStatement(); 
            stmt.executeUpdate(query);
            System.out.println("Se ha creado correctamente la tabla Libro");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error al crear la tabla Libro");
        }finally{
            stmt.close();
        }
    }
    
    public void crearTablaAutor() throws Exception {
        String query = "create table if not exists Autor("
			+ "id int primary key auto_increment, " //clave principal para identificar el registro de la tabla.
			+ "nombre varchar(100), "
                        + "apellidos varchar (100) ); " ;

                    
        Statement stmt = null;
        try{
            stmt = con.createStatement(); 
            stmt.executeUpdate(query); 
            System.out.println("Se ha creado correctamente la tabla Autor");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error al crear la tabla Autor");
        }finally{
            stmt.close();
        }
    }
    
    
    
    
    public void insertarDatos(String nombre, String apellidos) throws Exception {
     // Función que inserta un nuevo director
     String query = "insert into Autor(nombre, apellidos) values('"+nombre+"', '"+apellidos+"');";
     Statement stmt = null;
     
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Se ha añadido a la tabla Autor: " + nombre + " " + apellidos);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            stmt.close();
        }
    }
    
    public ArrayList<Autor> listarDatosAutores() throws Exception {
        // Funcion que devuelve una lista con los datos de “miTabla”
        ArrayList<Autor> autores = new ArrayList<Autor>();
        String query = "select * from Autor;";
        Statement stmt = null;
        ResultSet rs = null; // para tratar los datos
        Autor a;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){ // iteramos, se asegura que sigue habiendo un registro para recuperar la información
                a = new Autor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos")
                );                           
            //autores.add(rs.getInt(id)+ " - " + rs.getString("nombre") + " " + rs.getString("apellidos"));
            autores.add(a);
            }
  
            } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
           rs.close();
           stmt.close();
        }
        return autores;
    }

    public void borrarBDD() throws Exception{
     String query = "drop database " + baseDatos + ";";
        Statement stmt = null;
        try{
           stmt = con.createStatement();
           stmt.executeUpdate(query);
           System.out.println("Se ha borrado la base de datos correctamente");

        }catch (SQLException e){
           e.printStackTrace();
        }finally{
           stmt.close();
        }
    }
    public void mostrarAutores() throws Exception {
        
        ArrayList<Autor> autores = new ArrayList<Autor>();
        autores = listarDatosAutores();    

        for (Autor autor : autores) { 
            System.out.println(autor);
        }
    }
    
    public void insertarLibros(String titulo, String autor, String pais, String genero, int paginas, int autorId) throws Exception {
     // Función que inserta un nuevo director
     String query = "insert into Libro(titulo, autor, pais, genero, paginas, autorId) values('"+titulo+"', '"+autor+"','"+pais+"','"+genero+"',"+paginas+ "," + autorId + ");";
     Statement stmt = null;
     
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Se ha añadido a la tabla Libro, el libro: " + titulo + " " + autor);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            stmt.close();
        }
    }
    
     public ArrayList<Libro> listarDatosLibros() throws Exception {
        // Funcion que devuelve una lista con los datos de “miTabla”
        ArrayList<Libro> libros = new ArrayList<Libro>();
        String query = "select * from Libro;";
        Statement stmt = null;
        ResultSet rs = null; // para tratar los datos
        Libro l;
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
            while(rs.next()){ // iteramos, se asegura que sigue habiendo un registro para recuperar la información
                l = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("pais"),
                        rs.getString("genero"),
                        rs.getInt("paginas"),
                        rs.getInt("autorId")
                        
                        
                );                           
            //autores.add(rs.getInt(id)+ " - " + rs.getString("nombre") + " " + rs.getString("apellidos"));
            libros.add(l);
            }
  
            } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
           rs.close();
           stmt.close();
        }
        return libros;
    }
     public void mostrarLibros() throws Exception {
        
        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros = listarDatosLibros();    

        for (Libro libro : libros) { 
            System.out.println(libro);
        }
    }
     
    public void modificarAutor(Scanner entrada) throws Exception{
         mostrarAutores();
         int autorId;
         
         
        do{
            autorId = Pregunta.pideEntero("Qué autor quieres modificar según su identificador? (1= Patrick Rothfuss/ 2= George RR Martin)", entrada);
        }while(autorId != 1 && autorId != 2 );

        String campo ="";
        
        do{
           System.out.println("Qué campo quieres modificar del autor (nombre o apellidos)?");
           
           try{
               campo = entrada.nextLine();    
           }catch (Exception e){
               System.out.println("Valor incorrecto!!");
               entrada.next();
            }    
        }while(!campo.equals("nombre") && !campo.equals("apellidos"));
        
        String nuevoValor = "";
  
        
        do{
           System.out.println("Introduce nuevo valor para el campo modificado");
           try{
               nuevoValor = entrada.nextLine();
           }catch (Exception e){
               System.out.println("Valor incorrecto!!");
               entrada.next();
            }    
           
        }while(nuevoValor == "");   
        

        String query = "update Autor set " + campo + " = '" + nuevoValor + "' where id = " + autorId + ";";
        Statement stmt = null;
        try{
           stmt = con.createStatement();
           stmt.executeUpdate(query);
           System.out.println("Se ha modificado correctamente el autor");

        }catch (SQLException e){
           e.printStackTrace();
           System.out.println("Error al modificar autor");
        }finally{
           stmt.close();
        }
    }
    
     public void eliminarLibro(Scanner entrada) throws Exception{
         int libroId;
         mostrarLibros();
         
         do{
            libroId = Pregunta.pideEntero("Qué libro quieres modificar según su identificador? (1= El nombre del viento/ 2= Fuego y Sangre)", entrada);
        }while(libroId != 1 && libroId != 2 );

         
        String query = "delete from Libro where id= " + libroId + ";";
           Statement stmt = null;
           try{
              stmt = con.createStatement();
              stmt.executeUpdate(query);
              System.out.println("Se ha borrado el libro seleccionado");

           }catch (SQLException e){
              e.printStackTrace();
              System.out.println("Error al borrar el libro");
           }finally{
              stmt.close();
           }
     
     
    }
}

