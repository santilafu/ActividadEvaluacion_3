# 📘 Gestión de Datos de la Empresa XZET con Hibernate
### 1. Introducción

En este proyecto se desarrolla un sistema básico de gestión de empleados para la empresa XZET utilizando **Hibernate ORM**.
El objetivo principal es aplicar correctamente los conceptos de persistencia, mapeo objeto-relacional y acceso a datos mediante Java y Hibernate.

Se ha construido una aplicación Java con Maven en la que:

- Se configura Hibernate mediante hibernate.cfg.xml.

- Se crea una entidad Empleado utilizando anotaciones.

- Se implementa una clase DAO con métodos de guardar y obtener datos.

- Se desarrolla una aplicación de ejemplo que utiliza el DAO para realizar operaciones reales en la base de datos.

### 2. Configuración del Proyecto (Hibernate + Maven)

El proyecto utiliza Maven para gestionar dependencias, permitiendo una instalación limpia y automática de Hibernate, JPA, JAXB y el driver MySQL.

Fragmento del pom.xml relevante:
```xml
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>7.1.7.Final</version>
</dependency>

<dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>3.2.0</version>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.5.0</version>
</dependency>
```

Se creó la base de datos correspondiente:
```sql
CREATE DATABASE xzet;
USE xzet;
```
### 3. Configuración de Hibernate (hibernate.cfg.xml)

Se definieron los parámetros de conexión y el mapeo de la entidad Empleado:
```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/xzet?useSSL=false&amp;serverTimezone=UTC
</property>

<property name="hibernate.hbm2ddl.auto">update</property>

<mapping class="org.xzet.Empleado"/>
```
### 4. Creación de la entidad Empleado

Se implementó utilizando anotaciones de JPA:
```java
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "departamento")
    private String departamento;
}
```

**Hibernate genera la tabla automáticamente gracias a hbm2ddl.auto=update**.

### 5. Implementación de acceso a datos (DAO)

Se crea la clase EmpleadoDAO con dos métodos fundamentales:

### ✔ Guardar empleado
```java
public void guardarEmpleado(Empleado empleado) {
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

    session.persist(empleado);

    tx.commit();
    session.close();
}
```
### ✔ Obtener empleado
```java
Siguiendo la recomendación actual, se utiliza session.find(): 
ya que la session.get() está en desuso.

public Empleado obtenerEmpleado(int id) {
Session session = sessionFactory.openSession();
Empleado emp = session.find(Empleado.class, id);
session.close();
return emp;
}
```
## 6. Aplicación de ejemplo (Main)

La aplicación crea un empleado, lo guarda en la base de datos, lo recupera y muestra sus datos:
```java
EmpleadoDAO dao = new EmpleadoDAO();

Empleado e = new Empleado("Alberto", "Ruiz", "Informática");
dao.guardarEmpleado(e);

Empleado obtenido = dao.obtenerEmpleado(e.getId());

System.out.println("Empleado obtenido:");
System.out.println("Nombre: " + obtenido.getNombre());
System.out.println("Apellido: " + obtenido.getApellido());
System.out.println("Departamento: " + obtenido.getDepartamento());

7. Gestión de transacciones

Cada operación de escritura está envuelta en una transacción mediante:

Transaction tx = session.beginTransaction();
tx.commit();
```

Garantizando integridad y consistencia de datos.

## 8. Conclusiones

- El sistema desarrollado cumple con todos los objetivos de la actividad:

- Se ha configurado Hibernate correctamente.

- Se ha creado y mapeado una entidad persistente con anotaciones.

- Se han gestionado transacciones de forma adecuada.

- Se ha implementado un DAO siguiendo buenas prácticas.

- La aplicación es funcional, clara y escalable.

Este proyecto constituye una base sólida para ampliar la aplicación con nuevas entidades, relaciones y funcionalidades avanzadas.

### 🎓AUTOR: SANTIAGO LAFUENTE HERNÁNDEZ
- 2º DAM – Acceso a Datos - Tema 3
- README DESARROLLADO CON ACOMPAÑAMIENTO TÉCNICO DE ChatGPT