package negocio;

import datos.CategoriaDAO;
import datos.SubCategoriaDAO;
import datos.ProductoDAO;
import entidades.Categorias;
import entidades.Productos;
import entidades.SubCategorias;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ProductoControl {
    private final ProductoDAO DATOS;
    private final CategoriaDAO DATOSCAT;
    private final SubCategoriaDAO DATOSSC;
    private Productos obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public ProductoControl() {
        DATOS = new ProductoDAO();
        DATOSCAT =  new CategoriaDAO();
        DATOSSC = new SubCategoriaDAO();
        obj = new Productos();
        registrosMostrados = 0;
    }
    
    //Método listar
    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        DecimalFormat formateador = new DecimalFormat("$ #,###.##");
        List<Productos> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));
        //Rotulos de la tabla JTable
        String[] titulos = {"ID Producto", "ID Categoria", "Categoría", "ID Subcategoría", "Subcategoria", "Producto", "Precio", "Descuento", "Stock", "Tipo", "codigoQR", "Imagen", "Estado"};
        String estado;
        String[] registro = new String[13];
        //Agregar los titulos al modelo
        modeloTabla = new DefaultTableModel(null,titulos);
        registrosMostrados = 0;
        //Recorrer la lista de las categorias
        for(Productos item:lista){
            registrosMostrados++;
            //Verificar si esta activo o inactivo
            if (item.isEstado()){
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            
            //Llenar el registro
            registro[0] = Integer.toString(item.getIdProducto());
            registro[1] = Integer.toString(item.getIdCategoria());
            registro[2] = item.getNombreCategoria();
            registro[3] = Integer.toString(item.getIdSubcategoria());
            registro[4] = item.getNombreSubCategoria();
            registro[5] = item.getNombreProducto();
            registro[6] = formateador.format(item.getPrecioProducto());
            registro[7] = Integer.toString(item.getDescuentoProducto());
            registro[8] = Integer.toString(item.getExistenciaProducto());
            registro[9] = item.getTipoProducto();
            registro[10] = item.getCodigoQR();
            registro[11] = item.getImagenProducto();
            registro[12] = estado;
            
            //Agregar en registro al modelo
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    //Método para regresar  retornar las categorías
    public DefaultComboBoxModel seleccionarCategorias() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Categorias> lista = new ArrayList();
        
        lista = DATOSCAT.listarCategorias();
        for (Categorias item: lista) {
            items.addElement(new Categorias(item.getIdCategoria(), item.getNombreCategoria()));
        }
        return items;
    }
    
    //Método para regresar  retornar las Sub Categorías
    public DefaultComboBoxModel seleccionarSubCategorias() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<SubCategorias> lista = new ArrayList();
        
        lista = DATOSSC.listarSubCategorias();
        for (SubCategorias item: lista) {
            items.addElement(new SubCategorias(item.getIdSubCategoria(), item.getNombreSubCategoria()));
        }
        return items;
    }
    
    //Método insertar
    public String insertar(int idCategoria, String nombreCategoria, int idSubcategoria, String nombreSubCategoria, String nombreProducto, float precioProducto, int descuentoProducto, int existenciaProducto, String tipoProducto, String imagenProducto, String codigoQR){
        //Verificar que no exista la categoria a insertar
        if(DATOS.existe(nombreProducto)){
            return "El producto: '"+ nombreProducto +"' ya existe";
        } else {
            
            obj.setIdCategoria(idCategoria);
            obj.setNombreCategoria(nombreCategoria);
            obj.setIdSubcategoria(idSubcategoria);
            obj.setNombreSubCategoria(nombreSubCategoria);
            obj.setNombreProducto(nombreProducto);
            obj.setPrecioProducto(precioProducto);
            obj.setDescuentoProducto(descuentoProducto);
            obj.setExistenciaProducto(existenciaProducto);
            obj.setTipoProducto(tipoProducto);
            obj.setImagenProducto(imagenProducto);
            obj.setCodigoQR(codigoQR);
            obj.setEstado(true);
            
            //Llisto para insertar en la BD
            if (DATOS.insertar(obj)){
                return "OK";
            } else {
                return "Error en la inserción del registro";
            }
        }
    }
    
    //Método Actualizar
    public String actualizar(int id, int idCategoria, String nombreCategoria, int idSubcategoria, String nombreSubCategoria, String nombreProducto, String nombreProductoAnt, float precioProducto, int descuentoProducto, int existenciaProducto, String tipoProducto, String imagenProducto, String codigoQR){
        //1. Verificar si el usuario desea modificar el nombre de la categoría
        if (nombreProducto.equals(nombreProductoAnt)) {
            //2. Llenar el objeto
            obj.setIdProducto(id);
            obj.setIdCategoria(idCategoria);
            obj.setNombreCategoria(nombreCategoria);
            obj.setIdSubcategoria(idSubcategoria);
            obj.setNombreSubCategoria(nombreSubCategoria);
            obj.setNombreProducto(nombreProducto);
            obj.setPrecioProducto(precioProducto);
            obj.setDescuentoProducto(descuentoProducto);
            obj.setExistenciaProducto(existenciaProducto);
            obj.setTipoProducto(tipoProducto);
            obj.setImagenProducto(imagenProducto);
            obj.setCodigoQR(codigoQR);
            //obj.setEstado(true);
            
            //3. Actualizar el registro
            if (DATOS.actualizar(obj)){
                return "OK";
            } else {
                return "Error en la actualización del registro";
            }
        } else {
            if (DATOS.existe(nombreProducto)) {
                return "Ya existe la categoría.";
            } else {
                
                obj.setIdProducto(id);
                obj.setIdCategoria(idCategoria);
                obj.setNombreCategoria(nombreCategoria);
                obj.setIdSubcategoria(idSubcategoria);
                obj.setNombreSubCategoria(nombreSubCategoria);
                obj.setNombreProducto(nombreProducto);
                obj.setPrecioProducto(precioProducto);
                obj.setDescuentoProducto(descuentoProducto);
                obj.setExistenciaProducto(existenciaProducto);
                obj.setTipoProducto(tipoProducto);
                obj.setImagenProducto(imagenProducto);
                obj.setCodigoQR(codigoQR);
                //obj.setEstado(true);
            
                //3. Actualizar el registro
                if (DATOS.actualizar(obj)){
                    return "OK";
                } else {
                    return "Error en la actualización del registro";
                }
            }
        }
    }
    
    public String desactivar(int id) {
        if (DATOS.desactivar(id)){
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id) {
        if (DATOS.activar(id)){
            return "OK";
        } else {
            return "No se puede activar el registro";
        }
    }
    
    public int total() {
        return DATOS.total();
    }
    
    //Regresa el total de registros mostrados
    public int totalMostrados() {
        return registrosMostrados;
    }
}
