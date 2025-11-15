package org.xzet;

public class Main {
    public static void main(String[] args) {

        EmpleadoDAO dao = new EmpleadoDAO();

        // Crear empleado
        Empleado e = new Empleado("Alberto", "Ruiz", "Informática");

        // Guardar empleado
        dao.guardarEmpleado(e);

        // Obtenerlo
        Empleado obtenido = dao.obtenerEmpleado(e.getId());

        System.out.println("Empleado obtenido:");
        System.out.println("Nombre: " + obtenido.getNombre());
        System.out.println("Apellido: " + obtenido.getApellido());
        System.out.println("Departamento: " + obtenido.getDepartamento());
    }
}
