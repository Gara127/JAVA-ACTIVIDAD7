
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gara
 */
@Entity
public class Tienda {
    @Id @GeneratedValue long id;
    private String direccion;
    private int ventas;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="empleado",orphanRemoval = true) // se relaciona de uno a mucho. Si elimno la tienda los empleados se elimina. Mapeado con empleado
    private List <Empleado> empleados;

    public Tienda(String direccion, int ventas, List <Empleado> empleados) {
        this.direccion = direccion;
        this.ventas = ventas;
        this.empleados = empleados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Tienda{" + "id=" + id + ", direccion=" + direccion + ", ventas=" + ventas + ", empleados=" + empleados + '}';
    }
    
    
}
