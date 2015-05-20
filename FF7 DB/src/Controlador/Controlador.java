
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
    
    public void iniciar(){
        p.setExtendedState(VistaPrincipal.MAXIMIZED_BOTH);
        p.setVisible(true);
    }
    
    
}
