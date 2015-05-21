
package Modelo;

import Hibernate.POJO.Enemigos;
import Vista.VistaPrincipal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
     * Este método creará una cache de las imágenes necesarias para el programa.
     * Se usará en el primer inicio o si el usuario borrar por error la carpeta caché.
     * @param enemigos 
     * La lista de los enemigos.
     */
    public void creacionDeCaches(ArrayList<Enemigos> enemigos){
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
        File imagenesEnemigos = new File("cache/imagenes/enemigos");
        if(imagenesEnemigos.exists() == false){
            imagenesEnemigos.mkdir();
        }
        //Creacion de la cache de las imagenes de los enemigos.
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
    }
    
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
    
}
