
package Controlador;

import Hibernate.POJO.Armas;
import Hibernate.POJO.Canciones;
import Hibernate.POJO.Enemigos;
import Hibernate.POJO.Materia;
import Hibernate.POJO.Objetos;
import Hibernate.POJO.Personajes;
import Hibernate.POJO.Personajessecundarios;
import Modelo.Consultas;
import Modelo.Metodos;
import Vista.VistaPrincipal;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Pablo
 */

public class Controlador {
    
    //VISTAS
    VistaPrincipal p;
    
    //CLASES DE SOPORTE
    Consultas c;
    Metodos m;
    
    //COLECCIONES
    ArrayList<Armas> armas;
    ArrayList<Canciones> canciones;
    ArrayList<Enemigos> enemigos;
    ArrayList<Materia> materia;
    ArrayList<Objetos> objetos;
    ArrayList<Personajes> personajes;
    ArrayList<Personajessecundarios> personajessecundarios;
    
    /**Constructor de controlador que recibe la vista principal.
     * 
     * @param p 
     */
    
    public Controlador(VistaPrincipal p){
        this.p = p;
        c = new Consultas();
        m = new Metodos();
    }
    
    /**
     * Este método inicializa los listeners y los parámetros iniciales para el programa.
     */
    public void iniciar(){
        p.setExtendedState(VistaPrincipal.MAXIMIZED_BOTH);
        recogerTodo();
        m.creacionDeCaches(enemigos);
        
        //Asignamos el modelo a la lista de enemigos.
        p.listaEnemigos.setModel(m.modeloListaEnemigos(enemigos));
        
        //Listener que se encargara de mostrar un enemigo al seleccionarlo en la lista.
        p.listaEnemigos.addListSelectionListener((ListSelectionEvent) -> {
            Enemigos e = enemigos.get(p.listaEnemigos.getSelectedIndex());
            m.mostrarEnemigo(e, p);
        });
        
        //Preseleccionaremos el primer valor de la lista.
        p.listaEnemigos.setSelectedIndex(0);
        
        p.setVisible(true);
    }
    
    
    /**
     * Este método recoge toda la base de datos.
     */
    private void recogerTodo(){
        armas = c.recogerArmas();
        canciones = c.recogerCanciones();
        enemigos = c.recogerEnemigos();
        materia = c.recogerMateria();
        objetos = c.recogerObjetos();
        personajes = c.recogerPersonajes();
        personajessecundarios = c.recogerPersonajessecundarios();
    }
    
    
}
