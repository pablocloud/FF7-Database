
package Controlador;

import Extensiones.RenderizadorImagenTabla;
import Hibernate.POJO.Armas;
import Hibernate.POJO.Canciones;
import Hibernate.POJO.Enemigos;
import Hibernate.POJO.Materia;
import Hibernate.POJO.Objetos;
import Hibernate.POJO.Personajes;
import Hibernate.POJO.Personajessecundarios;
import Hilos.Reproductor;
import Modelo.Consultas;
import Modelo.Metodos;
import Vista.VistaPrincipal;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;

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
    
    //Hilos
    Reproductor repro;
    
    
    /**Constructor de controlador que recibe la vista principal.
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
        recogerTodo();
        //Crea la cache para las imagenes del programa.
        m.creacionDeCaches(enemigos,personajes);
        //Asignamos el modelo a la lista de enemigos.
        p.listaEnemigos.setModel(m.modeloListaEnemigos(enemigos));
        //Asignamos el modelo a la lista de armas.
        p.listaArmas.setModel(m.modeloListaArmas(armas));
        //Asignamos el modelo a la lista de canciones.
        p.listaMusica.setModel(m.modeloListaCanciones(canciones));
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
        
        //Modelo y atributos tabla materia.
        p.tablaMaterias.setModel(m.modeloTablaMaterias(materia));
        p.tablaMaterias.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {

                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                String valor = (String)table.getModel().getValueAt(row, 1);
                if (null != valor) switch (valor) {
                    case "Magia":
                        setBackground(Color.GREEN);
                        setForeground(Color.BLACK);
                        break;
                    case "Independiente":
                        setBackground(Color.PINK);
                        setForeground(Color.BLACK);
                        break;
                    case "Invocacion":
                        setBackground(Color.RED);
                        setForeground(Color.BLACK);
                        break;
                    case "Apoyo":
                        setBackground(Color.BLUE);
                        setForeground(Color.WHITE);
                        break;
                    case "Comando":
                        setBackground(Color.YELLOW);
                        setForeground(Color.BLACK);
                        break;
                    default:
                        setBackground(table.getBackground());
                        setForeground(table.getForeground());
                        break;
                }       
                return this;
            }   
        });
        
        //Modelo de la tabla de objetos.
        p.tablaObjetos.setModel(m.modeloTablaObjetos(objetos));
        
        //Listener que se encargara de mostrar un enemigo al seleccionarlo en la lista.
        p.listaEnemigos.addListSelectionListener((ListSelectionEvent) -> {
            Enemigos e = enemigos.get(p.listaEnemigos.getSelectedIndex());
            m.mostrarEnemigo(e, p);
        });
        
        p.listaArmas.addListSelectionListener((ListSelectionEvent) -> {
            Armas ar = armas.get(p.listaArmas.getSelectedIndex());
            m.mostrarArma(ar, p);
        });
        
        //Preseleccionaremos el primer valor de todas las listas.
        p.listaEnemigos.setSelectedIndex(0);
        p.listaArmas.setSelectedIndex(0);
        p.listaMusica.setSelectedIndex(0);
        
        /**
         * Este listener reproduce la cancion seleccionada de la lista de musica.
         */
        p.btnReproducirMusica.addActionListener((ActionEvent) -> {
            int posicion = p.listaMusica.getSelectedIndex();
            Canciones can = canciones.get(posicion);
            if(repro != null && repro.isAlive()){
                repro.stop();
            }
            repro = new Reproductor(can);
            repro.start();
        });
        
        /**
         * Este listener para la musica que se este reproduciendo.
         */
        p.btnPararMusica.addActionListener((ActionEvent) -> {
            if(repro != null && repro.isAlive()){
                repro.stop();
            }
        });
        
        /**
         * Listener para detectar los cambios en el tab seleccionado.
         */
        p.contenedor.addChangeListener((ChangeEvent e) -> {
            JTabbedPane panel = (JTabbedPane) e.getSource();
            //Si seleccionamos el de la musica, avisamos del streaming.
            if(panel.getSelectedIndex() == 5){
                JOptionPane.showMessageDialog(panel, 
                        "Esta función requiere internet, la música se reproduce en streaming.");
            }
        });
        
        p.setExtendedState(VistaPrincipal.MAXIMIZED_BOTH);
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
