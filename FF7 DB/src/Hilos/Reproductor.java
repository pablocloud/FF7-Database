
package Hilos;

import Hibernate.POJO.Canciones;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * @author Pablo
 */

public class Reproductor extends Thread{

    private final Canciones can;
    
    public Reproductor(Canciones can){
        this.can = can;
    }
    
    @Override
    public void run() {
        try {
            Player pl;
            URL url = new URL("http://swimpee.eu/personal/ff7db/"+can.getMp3());
            pl = new Player(url.openStream());
            pl.play();
        } catch (MalformedURLException | JavaLayerException ex) {
            Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
