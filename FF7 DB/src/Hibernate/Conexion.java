
package Hibernate;

import javafx.application.Application;
import javax.swing.JOptionPane;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * @author Pablo
 */
public class Conexion {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure(Conexion.class.getResource("/Hibernate/Hibernate.cfg.xml")).buildSessionFactory();
        } catch (Exception ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw ex;
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
