
package Controlador;

import com.alee.laf.WebLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Pablo
 */

public class Iniciar {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel ( new WebLookAndFeel() );
            UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
            UIManager.setLookAndFeel ( WebLookAndFeel.class.getCanonicalName() );
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
