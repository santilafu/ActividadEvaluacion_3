//Se realiza la clase Empleado en el paquete org.xzet que sera Entidad Padre.
package org.xzet;
// Importamos libreria perteneciente a jakarta.persistence.*;
import jakarta.persistence.*;

@Entity// Definimos la tabla empleado
@Table(name = "empleado")// Definimos el nombre de la tabla empleado
public class Empleado {
    @Id// Definimos la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Definimos la estrategia de generacion de la clave primaria
    private int id;// Definimos el atributo id

    @Column(name = "nombre")// Definimos el nombre de la columna nombre
    private String nombre;// Definimos el atributo nombre

    @Column(name = "apellido")// Definimos el nombre de la columna apellido
    private String apellido;// Definimos el atributo apellido


    @Column(name = "departamento")// Definimos el nombre de la columna puesto
    private String departamento;// Definimos el atributo puesto

    // Constructor vacio
    public Empleado() {}

    // Constructor con parametros
    public Empleado(String nombre,String apellido, String puesto) {
        this.nombre = nombre;
        this.departamento = puesto;
        this.apellido=apellido;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Empleado{id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", puesto='" + departamento + '\'' +
                '}';
    }

    // Getters y setters
    public int getIdempleado() {
        return id;
    }

    public void setIdempleado(int idempleado) {
        this.id = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setPuesto(String departamento) {
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }
}
