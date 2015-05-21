
package Controlador;

import Extensiones.RenderizadorImagenTabla;
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
        //Crea la cache para las imagenes del programa.
        m.creacionDeCaches(enemigos,personajes);
        //Asignamos el modelo a la lista de enemigos.
        p.listaEnemigos.setModel(m.modeloListaEnemigos(enemigos));
        //Asignamos el modelo a la lista de armas.
        p.listaArmas.setModel(m.modeloListaArmas(armas));
        /*Asignamos el modelo a la tabla de los personajes, también le asignamos el renderizador
        de la imagen y su ancho y altura.
        */
        p.tablaPersonajes.setModel(m.modeloTablaPersonajes(personajes));
        p.tablaPersonajes.getColumnModel().getColumn(0).setCellRenderer(new RenderizadorImagenTabla());
        p.tablaPersonajes.setRowHeight(100);
        p.tablaPersonajes.getColumnModel().getColumn(0).setWidth(100);
        p.tablaPersonajes.getColumnModel().getColumn(0).setMaxWidth(100);
        p.tablaPersonajes.getColumnModel().getColumn(0).setMinWidth(100);
        p.tablaPersonajes.getColumnModel().getColumn(0).setWidth(100);
        
        //Listener que se encargara de mostrar un enemigo al seleccionarlo en la lista.
        p.listaEnemigos.addListSelectionListener((ListSelectionEvent) -> {
            Enemigos e = enemigos.get(p.listaEnemigos.getSelectedIndex());
            m.mostrarEnemigo(e, p);
        });
        
        //Preseleccionaremos el primer valor de todas las listas.
        p.listaEnemigos.setSelectedIndex(0);
        p.listaArmas.setSelectedIndex(0);
        
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
