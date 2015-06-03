
package Modelo;

import Extensiones.RenderizadorImagenTabla;
import Hibernate.POJO.Armas;
import Hibernate.POJO.Canciones;
import Hibernate.POJO.Enemigos;
import Hibernate.POJO.Materia;
import Hibernate.POJO.Objetos;
import Hibernate.POJO.Personajes;
import Vista.VistaPrincipal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 * @author Pablo
 */

public class Metodos {
    
    /**
     * Crea el modelo para la lista de enemigos.
     * @param lista
     * Arraylist de los enemigos
     * @return 
     * Devuelve el defaultlistmodel
     */
    public DefaultListModel modeloListaEnemigos(ArrayList<Enemigos> lista){
        DefaultListModel modelo = new DefaultListModel();
        lista.stream().forEach((e) -> {
            modelo.addElement(e.getNombre());
        });
        return modelo;
    }
    
    /**
     * Crea el modelo para la lista de armas.
     * @param lista
     * Arraylist de las armas
     * @return 
     * Devuelve el defaultlistmodel
     */
    public DefaultListModel modeloListaArmas(ArrayList<Armas> lista){
        DefaultListModel modelo = new DefaultListModel();
        lista.stream().forEach((e) -> {
            modelo.addElement(e.getNombre());
        });
        return modelo;
    }
    
    /**
     * Crea el modelo para la lista de canciones.
     * @param lista
     * Arraylist de las canciones.
     * @return 
     * Devuelve el defaultlistmodelo.
     */
    public DefaultListModel modeloListaCanciones(ArrayList<Canciones> lista){
        DefaultListModel modelo = new DefaultListModel();
        lista.stream().forEach((can) -> {
            modelo.addElement(can.getNombre());
        });
        return modelo;
    }
    
    /**
     * Este método se encarga de mostrar la información de un enemigo en sus lugares correspondientes.
     * @param e
     * Enemigo a mostrar.
     * @param p 
     * Vista donde se muestra.
     */
    public void mostrarEnemigo(Enemigos e, VistaPrincipal p){
        //Obtendremos los campos de los enemigos para un uso mas comodo.
        //Creamos este array para enviarselo luego al modelo de la tabla.
        Object[] datos = new Object[5];
            datos[0] = e.getPg();
            datos[1] = e.getMp();
            datos[2] = e.getExp();
            datos[3] = e.getGil();
            datos[4] = e.getAp();
        String absorve = e.getAbsorve();
        String debil = e.getDebil();
        String fuerte = e.getFuerte();
        String inmune = e.getInmune();
        int nivel = e.getNivel();
        String nombre = e.getNombre();
        p.nombreEnemigoYNivel.setText(nombre+", Nivel "+nivel+".");
        p.tablaDatosEnemigos.setModel(modeloTablaDatosEnemigos(datos));
        p.adicionalEnemigo.setText("Es débil a : "+debil+".\n");
        p.adicionalEnemigo.append("Resiste a : "+fuerte+".\n");
        p.adicionalEnemigo.append("Absorve : "+absorve+".\n");
        p.adicionalEnemigo.append("En inmune : "+inmune+".\n");
        try {
            //Leemos la imagen de la carpeta cache.
            BufferedImage read = ImageIO.read(new File("cache/"+e.getImagen()));
            //Hacemos un reescalado a la dimensión del label, y le decimos que lo haga de forma algo decente.
            p.imagenEnemigos.setIcon(new ImageIcon(read.getScaledInstance(p.imagenEnemigos.getWidth(), p.imagenEnemigos.getHeight(), BufferedImage.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Muestra los datos de un arma en su lugar correspondiente.
     * @param arma
     * El arma a mostrar.
     * @param vp 
     * Vista principal.
     */
    public void mostrarArma(Armas arma, VistaPrincipal vp){
        String nombre = arma.getNombre();
        String equipadopor = arma.getEquipadopor();
        Object[] tabla = new Object[5];
            tabla[0] = arma.getAtaque();
            tabla[1] = arma.getGolpe();
            tabla[2] = arma.getMateria9();
            tabla[3] = arma.getCoste();
            tabla[4] = arma.getLocalizacion();
        vp.tablaDatosArmas.setModel(modeloTablaDatosArma(tabla));
        tabla = new Object[8];
            tabla[0] = arma.getMateria();
            tabla[1] = arma.getMateria2();
            tabla[2] = arma.getMateria3();
            tabla[3] = arma.getMateria4();
            tabla[4] = arma.getMateria5();
            tabla[5] = arma.getMateria6();
            tabla[6] = arma.getMateria7();
            tabla[7] = arma.getMateria8();
        vp.txtNombreArma.setText(nombre+", "+equipadopor+".");
        vp.tablaRanurasArma.setModel(modeloTablaRanurasArma(tabla));
        vp.tablaRanurasArma.setRowHeight(80);
        for (int i = 0; i < vp.tablaRanurasArma.getColumnCount(); i++) {
            vp.tablaRanurasArma.getColumnModel().getColumn(i).setCellRenderer(new RenderizadorImagenTabla());
        }
        vp.notasArmas.setText(arma.getNotas());
    }
    
    /**
     * Este método creará una cache de las imágenes necesarias para el programa.
     * Se usará en el primer inicio o si el usuario borrar por error la carpeta caché.
     * @param enemigos 
     * La lista de los enemigos.
     * @param personajes
     * La lista de los personajes
     */
    public void creacionDeCaches(ArrayList<Enemigos> enemigos,ArrayList<Personajes> personajes){
        //Primero comprobaremos el directorio caches.
        File cache = new File("cache");
        //Se creara solo si no existe.
        if(cache.exists() == false){
            cache.mkdir();
        }
        File imagenes = new File("cache/imagenes");
        if(imagenes.exists() == false){
            imagenes.mkdir();
        }
        //Creacion de la cache de las imagenes de los enemigos.
        File imagenesEnemigos = new File("cache/imagenes/enemigos");
        if(imagenesEnemigos.exists() == false){
            imagenesEnemigos.mkdir();
        }
        enemigos.stream().forEach((enemigo) -> {
            File imagen = new File("cache/"+enemigo.getImagen());
            if (imagen.exists() == false) {
                try {
                    BufferedImage read = ImageIO.read(new URL("http://swimpee.eu/personal/ff7db/"+enemigo.getImagen()));
                    ImageIO.write(read, "png", new File("cache/"+enemigo.getImagen()));
                } catch (IOException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //Creacion de la cache de las imagenes de los personajes.
        File imagenesPersonajes = new File("cache/imagenes/personajes");
        if(imagenesPersonajes.exists() == false){
            imagenesPersonajes.mkdir();
        }
        personajes.stream().forEach((personaje) -> {
            File imagen = new File("cache/"+personaje.getImagen());
            if (imagen.exists() == false) {
                try {
                    BufferedImage read = ImageIO.read(new URL("http://swimpee.eu/personal/ff7db/"+personaje.getImagen()));
                    ImageIO.write(read, "png", new File("cache/"+personaje.getImagen()));
                } catch (IOException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //Creación de cache de las imagenes de las ranuras de las armas.
        File imagenesRanuras = new File("cache/imagenes/ranuras");
        if(imagenesRanuras.exists() == false){
            imagenesRanuras.mkdir();
        }
        File ranura = new File("cache/imagenes/ranuras/1-nolink.gif");
        if(ranura.exists() == false){
            try {
                BufferedImage read = ImageIO.read(new URL("http://swimpee.eu/personal/ff7db/imagenes/ranuras/1-nolink.gif"));
                ImageIO.write(read, "png", new File("cache/imagenes/ranuras/1-nolink.gif"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ranura = new File("cache/imagenes/ranuras/2-link.gif");
        if(ranura.exists() == false){
            try {
                BufferedImage read = ImageIO.read(new URL("http://swimpee.eu/personal/ff7db/imagenes/ranuras/2-link.gif"));
                ImageIO.write(read, "png", new File("cache/imagenes/ranuras/2-link.gif"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ranura = new File("cache/imagenes/ranuras/blanco.png");
        if(ranura.exists() == false){
            try {
                BufferedImage read = ImageIO.read(new URL("http://swimpee.eu/personal/ff7db/imagenes/ranuras/blanco.png"));
                ImageIO.write(read, "png", new File("cache/imagenes/ranuras/blanco.png"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Modelo de tabla con los datos básicos de los enemigos.
     * @param datos
     * Array de datos.
     * @return 
     * Devuelve el defaultablemodel.
     */
    private DefaultTableModel modeloTablaDatosEnemigos(Object[] datos){
        DefaultTableModel modelo = new DefaultTableModel(){
            //Con esto haremos que no sea editable la tabla.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            modelo.addColumn("PG");
            modelo.addColumn("PM");
            modelo.addColumn("EXP");
            modelo.addColumn("GIL");
            modelo.addColumn("AP");
            modelo.addRow(datos);
        return modelo;
    }
    
    /**
     * Modelo de tabla para los personajes.
     * @param personajes
     * Arraylist con los personajes a mostrar.
     * @return 
     * Devuelve el defaultablemodel.
     */
    public DefaultTableModel modeloTablaPersonajes(ArrayList<Personajes> personajes){
        DefaultTableModel modelo = new DefaultTableModel(){
            //Con esto haremos que no sea editable la tabla.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            modelo.addColumn("Imagen");
            modelo.addColumn("Nombre");
            modelo.addColumn("Arma");
            modelo.addColumn("Ocupación");
            modelo.addColumn("Lugar de nacimiento");
            modelo.addColumn("Fecha de nacimiento");
            Object[] fila = new Object[6];
            personajes.stream().forEach((personaje) ->{
            try {
                BufferedImage read = ImageIO.read(new File("cache/"+personaje.getImagen()));
                fila[0] = new ImageIcon(read.getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH));
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
                fila[1] = personaje.getNombre();
                fila[2] = personaje.getArma();
                fila[3] = personaje.getOcupacion();
                fila[4] = personaje.getLugarna();
                fila[5] = personaje.getFechana();
                modelo.addRow(fila);
            });
        return modelo;
    }
    
    /**
     * Tabla con los datos básicos de un arma.
     * @param datos
     * Array con los datos.
     * @return 
     * Devuelve el defaulttablemodel.
     */
    private DefaultTableModel modeloTablaDatosArma(Object[] datos){
        DefaultTableModel modelo = new DefaultTableModel(){
            //Con esto haremos que no sea editable la tabla.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            modelo.addColumn("Ataque");
            modelo.addColumn("Golpe %");
            modelo.addColumn("Crecimiento");
            modelo.addColumn("Coste");
            modelo.addColumn("Localización");
            modelo.addRow(datos);
        return modelo;
    }
    
    private DefaultTableModel modeloTablaRanurasArma(Object[] datos){
        DefaultTableModel modelo = new DefaultTableModel(){
            //Con esto haremos que no sea editable la tabla.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            modelo.addColumn("Ranura 1");
            modelo.addColumn("Ranura 2");
            modelo.addColumn("Ranura 3");
            modelo.addColumn("Ranura 4");
            modelo.addColumn("Ranura 5");
            modelo.addColumn("Ranura 6");
            modelo.addColumn("Ranura 7");
            modelo.addColumn("Ranura 8");
            Object[] fila = new Object[8];
            for(int i = 0; i < fila.length; i++){
                try {
                    fila[i] = new ImageIcon(ImageIO.read(new File("cache/"+datos[i])));
                } catch (IOException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            modelo.addRow(fila);
        return modelo;
    }
    
    /**
     * Modelo de tabla par alas materias.
     * @param materias
     * Arraylist de las materias.
     * @return 
     * Devuelve el defaulttablemodel.
     */
    public DefaultTableModel modeloTablaMaterias(ArrayList<Materia> materias){
        DefaultTableModel modelo = new DefaultTableModel(){
            //Con esto haremos que no sea editable la tabla.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo");
            modelo.addColumn("Descripción");
            Object[] fila = new Object[3];
            materias.stream().forEach((mat) -> {
                fila[0] = mat.getNombre();
                fila[1] = mat.getTipo();
                fila[2] = mat.getDescripcion();
            modelo.addRow(fila);
            });
        return modelo;
    }
    
    /**
     * Modelo de tabla para los objetos.
     * @param objetos
     * Arraylist de objetos a mostrar.
     * @return 
     * Devuelve el defaulttablemodel con los datos.
     */
    public DefaultTableModel modeloTablaObjetos(ArrayList<Objetos> objetos){
        DefaultTableModel modelo = new DefaultTableModel(){
            //Con esto haremos que no sea editable la tabla.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripción");
            Object[] fila = new Object[2];
            objetos.stream().forEach((obj) -> {
                fila[0] = obj.getNombre();
                fila[1] = obj.getDescripcion();
            modelo.addRow(fila);
            });
        return modelo;
    }
    
}
