
package Controlador;

import Vista.VistaPrincipal;

/**
 * @author Pablo
 */

public class Controlador {
    
    //VISTAS
    VistaPrincipal p;
    
    public Controlador(VistaPrincipal p){
        this.p = p;
    }
    
    /**
     * Este método inicializa los listeners y los parámetros iniciales para el programa.
     */
    public void iniciar(){
        p.setExtendedState(VistaPrincipal.MAXIMIZED_BOTH);
        p.setVisible(true);
    }
    
    
}
