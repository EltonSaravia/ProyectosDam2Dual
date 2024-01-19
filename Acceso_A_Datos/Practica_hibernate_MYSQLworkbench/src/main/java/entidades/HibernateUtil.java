package entidades;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = construirSessionFactory();

    private static SessionFactory construirSessionFactory() {
        try {
            // Crear la SessionFactory de hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Asegúrate de registrar la excepción, ya que podría no mostrarse
            System.err.println("La creación inicial de SessionFactory falló." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void cerrar() {
        // Cerrar caches y pools de conexiones
        getSessionFactory().close();
    }
}
