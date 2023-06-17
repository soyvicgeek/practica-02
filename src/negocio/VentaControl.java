package negocio;

import datos.ProductoDAO;
import datos.VentaDAO;
import entidades.DetalleVenta;
import entidades.Productos;
import entidades.Venta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VentaControl {
    private final VentaDAO DATOS;
    private final ProductoDAO DATOSPROD;
    private Venta obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public VentaControl() {
        DATOS = new VentaDAO();
        DATOSPROD = new ProductoDAO();
        obj = new Venta();
        registrosMostrados = 0;
    }
    
    //Método listar
    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Venta> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));
        //Rotulos de la tabla JTable
        String[] titulos = {"ID Venta", "ID Cliente", "Nombre del Cliente", "Fecha", "Total", "IVA", "Estado"};
        String[] registro = new String[7];
        //Agregar los titulos al modelo
        modeloTabla = new DefaultTableModel(null,titulos);
        registrosMostrados = 0;
        //Formato a fechas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Recorrer la lista de las categorias
        for(Venta item:lista){
            registrosMostrados++;
            
            //Llenar el registro
            registro[0] = Integer.toString(item.getIdVenta());
            registro[1] = Integer.toString(item.getIdCliente());
            registro[2] = item.getNombreCliente();
            registro[3] = sdf.format(item.getFecha());
            registro[4] = Double.toString(item.getTotal());
            registro[5] = Double.toString(item.getIva());
            registro[6] = item.getEstado();
            
            //Agregar en registro al modelo
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    public Productos obtenerProducto(int ID) {
        Productos prod = null;  
        prod = DATOSPROD.obtenerProducto(ID);
        
        return prod;
    }
    
    //Método insertar
    public String insertar(int idCliente, double total, double iva, DefaultTableModel detalles){
             
        obj.setIdCliente(idCliente);
        obj.setTotal(total);
        obj.setIva(iva);
        //Recorrer los detalles
        List<DetalleVenta> detalleVenta = new ArrayList();
        int idP;
        int cantidad;
        double precio;
        double descuento;
        //llenar lista
        //ID Producto, Nombre Producto, Cantidad, Precio, Descuentos, Subtotal
        for(int i=0; i<detalles.getRowCount(); i++){
            idP = Integer.parseInt(detalles.getValueAt(i, 0).toString());
            cantidad = Integer.parseInt(detalles.getValueAt(i, 2).toString());
            precio = Double.parseDouble(detalles.getValueAt(i, 3).toString());
            descuento = Double.parseDouble(detalles.getValueAt(i, 4).toString());
            detalleVenta.add(new DetalleVenta(idP,cantidad,precio,descuento));
        }
        obj.setDetalles(detalleVenta);

        //Llisto para insertar en la BD
        if (DATOS.insertar(obj)){
            return "OK";
        } else {
            return "Error en la inserción del registro";
        }
    }  
    
    public String cancelarVenta(int id) {
        if (DATOS.cancelarVenta(id)){
            return "OK";
        } else {
            return "No se puedo cancelar la venta " + id;
        }
    }
    
}
