package vista;

import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class imgTabla extends DefaultTableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        // Recuperar la imagen desde la URL
        ImageIcon imageIcon = null;
        try {
            URL imageUrl = new URL((String) value);
            Image image = java.awt.Toolkit.getDefaultToolkit().getImage(imageUrl);
            imageIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Mostrar la imagen en la celda
        setIcon(imageIcon);
        setText(null);
        setHorizontalAlignment(CENTER);
        
        return this;
    }
    
}
