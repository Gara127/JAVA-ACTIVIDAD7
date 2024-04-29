
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Gara
 */
public class GestionaTiendas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;    

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:tiendasDB.tmp;drop");
        final EntityManager em = emf.createEntityManager();
        
       
        
        
        Empleado empleado1 = new Empleado("Gara", "González");
        Empleado empleado2 = new Empleado("Pepe", "Martín");
        Empleado empleado3 = new Empleado("Laura", "Pérez");
        
        List<Empleado> empleados = List.of(empleado1,empleado2,empleado3);

        
        Tienda tienda1 = new Tienda("Calle El Bernegal",10000, empleados);
        Tienda tienda2 = new Tienda("Calle s/c",20000, empleados);
        Tienda tienda3 = new Tienda("Calle La Laguna",30000, empleados);
        
        empleado1.setTienda(tienda1);
        empleado1.setTienda(tienda2);
        empleado1.setTienda(tienda3);
        
        em.getTransaction().begin();
        em.persist(tienda1);
        em.persist(tienda2);
        em.persist(tienda3);
        em.getTransaction().commit();
        
        
        
        do {
            System.out.println();
            System.out.println("Quieres hacer alguna operación?");
            System.out.println("1. Mostrar los empleados");
            System.out.println("2. Mostrar las tiendas");
            System.out.println("3. Mostrar tiendas ordenadas por ventas");
            System.out.println("4. Editar un empleado");
            System.out.println("5. Crear una nueva tienda");
            System.out.println("0. Salir");

            opcion = Pregunta.pideEntero("Introduzca la operación que desea realizar: ", entrada);

            switch (opcion) {
                case 1:
                    mostrarEmpleados(em);
                    break;
                case 2:
                    mostrarTiendas(em);
                    break;
                    case 3:
                    System.out.println("Ups no se ha encontrado el Case,  sin hacer no me dio tiempo :( ");
                    break;
                case 4:
                    //modificarEmpleado(em);
                    System.out.println("Case a medio hacer ( lo dejo mal montado entre comentarios, no di con la query y no tuve tiempo tampoco, :(  ");
                    break;  
                case 5:
                    crearTienda(em, empleados);
                    break;
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
    public static List <Tienda> mostrarTiendas (final EntityManager em){
        final List<Tienda> tiendas;

        final TypedQuery<Tienda> query = em.createQuery("SELECT tienda From Tienda tienda", Tienda.class);

        tiendas = query.getResultList();
        
        tiendas.forEach(tienda -> {});
          
            System.out.println(tiendas.toString());
            
        
            return tiendas;

    }
    public static List <Empleado> mostrarEmpleados (final EntityManager em){
        final List<Empleado> empleados;

        final TypedQuery<Empleado> query = em.createQuery("SELECT empleado From Empleado empleado", Empleado.class);

        empleados = query.getResultList();
        
        empleados.forEach(empleado -> {});
          
            System.out.println(empleados.toString());
            
        
            return empleados;

    }
       /* public static void modificarEmpleado (final EntityManager em, Scanner entrada){
        mostrarEmpleados(em);
        List <Empleado> empleados;
        int empleadoId;
        
        do{
            empleadoId = Pregunta.pideEntero("Elige el id del empleado que quieres modificar (4-5-6))", entrada);
        
        }while(empleadoId != 4 && empleadoId != 5 && empleadoId != 6 );
        
        
        TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e where id=: empleadoId, Empleado.class");
        query.setParameter("id","empleadoId");
        empleados = query.getResultList();
        em.getTransaction().begin();
        for (Empleado e : empleados) {
            e.set.nombre="Gara“;
            }
        em.getTransaction().commit();
    } */
        public static void crearTienda (final EntityManager em, List<Empleado> empleados){
           
            
            Tienda tienda3 = new Tienda("Calle El Paso",60000, empleados);
            em.getTransaction().begin();
            em.persist(tienda3);
            em.getTransaction().commit();
            mostrarTiendas(em);
        }
}
