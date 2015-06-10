
package Modelo;

import Hibernate.Conexion;
import Hibernate.POJO.Armas;
import Hibernate.POJO.Canciones;
import Hibernate.POJO.Enemigos;
import Hibernate.POJO.Materia;
import Hibernate.POJO.Objetos;
import Hibernate.POJO.Personajes;
import Hibernate.POJO.Personajessecundarios;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 * Esta clase se encarga de las consultas básicas de la aplicación.
 * Se trabajará con arraylist.
 * @author Pablo
 */

public class Consultas {
      
    //Todos los métodos realizan la acción de recoger todos los valores de la base de datos.
    
    /**
     * Este método recoge todas las canciones de la base de datos.
     * @return 
     * Devuelve un arraylist.
     */
    public ArrayList<Canciones> recogerCanciones(){
        ArrayList<Canciones> lista;
        Session s = Conexion.getSessionFactory().openSession();
        lista = (ArrayList<Canciones>) s.createQuery("From Canciones").list();
        s.close();
        return lista;
    }
    
    /**
     * Este método recoge todas las armas de la base de datos.
     * @return 
     * Devuelve un arraylist.
     */
    public ArrayList<Armas> recogerArmas(){
        ArrayList<Armas> lista;
        Session s = Conexion.getSessionFactory().openSession();
        lista = (ArrayList<Armas>) s.createQuery("From Armas").list();
        s.close();
        return lista;
    }
    
    /**
     * Este método recoge todas los enemigos de la base de datos.
     * @return 
     * Devuelve un arraylist.
     */
    public ArrayList<Enemigos> recogerEnemigos(){
        ArrayList<Enemigos> lista;
        Session s = Conexion.getSessionFactory().openSession();
        lista = (ArrayList<Enemigos>) s.createQuery("From Enemigos").list();
        s.close();
        return lista;
    }
    
    /**
     * Este método recoge todas las materias de la base de datos.
     * @return 
     * Devuelve un arraylist.
     */
    public ArrayList<Materia> recogerMateria(){
        ArrayList<Materia> lista;
        Session s = Conexion.getSessionFactory().openSession();
        lista = (ArrayList<Materia>) s.createQuery("From Materia").list();
        s.close();
        return lista;
    }
    
    /**
     * Este método recoge todas los objetos de la base de datos.
     * @return 
     * Devuelve un arraylist.
     */
    public ArrayList<Objetos> recogerObjetos(){
        ArrayList<Objetos> lista;
        Session s = Conexion.getSessionFactory().openSession();
        lista = (ArrayList<Objetos>) s.createQuery("From Objetos").list();
        s.close();
        return lista;
    }
    
    /**
     * Este método recoge todas los personajes de la base de datos.
     * @return 
     * Devuelve un arraylist.
     */
    public ArrayList<Personajes> recogerPersonajes(){
        ArrayList<Personajes> lista;
        Session s = Conexion.getSessionFactory().openSession();
        lista = (ArrayList<Personajes>) s.createQuery("From Personajes").list();
        s.close();
        return lista;
    }
    
    /**
     * Este método recoge todas los personajes secundarios de la base de datos.
     * @return 
     * Devuelve un arraylist.
     */
    public ArrayList<Personajessecundarios> recogerPersonajessecundarios(){
        ArrayList<Personajessecundarios> lista;
        Session s = Conexion.getSessionFactory().openSession();
        lista = (ArrayList<Personajessecundarios>) s.createQuery("From Personajessecundarios").list();
        s.close();
        return lista;
    }
}
