package Renderizadores;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Esta clase la usaremos para mostrar una imagen en una celda de una tabla.
 * @author pablo
 */
public class RenderizadorImagenTabla extends DefaultTableCellRenderer {

    JLabel lbl = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        lbl.setIcon((ImageIcon) value);
        return lbl;
    }
}
