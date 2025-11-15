package org.xzet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpleadoDAO {

    private SessionFactory sessionFactory;

    public EmpleadoDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    // Guardar empleado
    public void guardarEmpleado(Empleado empleado) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(empleado);

        tx.commit();
        session.close();
    }

    // Obtener empleado por ID
    public Empleado obtenerEmpleado(int id) {
        Session session = sessionFactory.openSession();
        Empleado emp = session.find(Empleado.class, id);
        session.close();
        return emp;
    }
}
