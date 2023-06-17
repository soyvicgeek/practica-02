package vista.utils;

import vista.*;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImgProductsTable extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Si el valor de la celda es una cadena que representa una ruta de imagen, cargue la imagen y establezca el icono del JLabel en la imagen.
        if (value instanceof String) {
            String imagePath = (String) value;
            File archivo = new File("src/imagenes/productos/" + imagePath);
            ImageIcon imagen;
            
            if(imagePath.isEmpty() || !archivo.exists() ) {
                imagen = new ImageIcon("src/imagenes/productos/producto_default.jpg");   
            } else {
                imagen = new ImageIcon("src/imagenes/productos/" + imagePath);   
            }
              
            ImageIcon icon = new ImageIcon(imagen.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            
            label.setIcon(icon);
            label.setText("");
        }
        return label;
    }
    
}
