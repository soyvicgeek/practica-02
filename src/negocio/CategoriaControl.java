package negocio;

import datos.CategoriaDAO;
import entidades.Categorias;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class CategoriaControl {
    private final CategoriaDAO DATOS;
    private Categorias obj;
    private DefaultTableModel modeloTabla;
    
    public CategoriaControl() {
        DATOS = new CategoriaDAO();
        obj = new Categorias();
    }
    
    //Método listar
    public DefaultTableModel listar(String texto) {
        List<Categorias> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        //Rotulos de la tabla JTable
        String[] titulos = {"ID", "Categoria", "Descripción", "Observaciones", "Imagen", "Estado"};
        String estado;
        String[] registro = new String[6];
        //Agregar los titulos al modelo
        modeloTabla = new DefaultTableModel(null,titulos);
        //Recorrer la lista de las categorias
        for(Categorias item:lista){
            
            //Verificar si esta activo o inactivo
            if (item.isActivo()){
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            
            //Llenar el registro
            registro[0] = Integer.toString(item.getIdCategoria());
            registro[1] = item.getNombreCategoria();
            registro[2] = item.getDescripcionCategoria();
            registro[3] = item.getObservaciones();
            registro[4] = item.getImagenCategoria();
            registro[5] = estado;
            
            //Agregar en registro al modelo
            modeloTabla.addRow(registro);
        }
        return modeloTabla;
    }
    
    //Método insertar
    public String insertar(String nombre, String img, String descripcion, String obs){
        //Verificar que no exista la categoria a insertar
        if(DATOS.existe(nombre)){
            return "La Categoria '"+ nombre +"' ya existe";
        } else {
            obj.setNombreCategoria(nombre);
            obj.setImagenCategoria(img);
            obj.setDescripcionCategoria(descripcion);
            obj.setObservaciones(obs);
            obj.setActivo(true);
            
            //Llisto para insertar en la BD
            if (DATOS.insertar(obj)){
                return "OK";
            } else {
                return "Error en la inserción del registro";
            }
        }
    }
    
    //Método Actualizar
    public String actualizar(int id, String nombre, String nombreAnt, String descripcion, String observaciones, String imagen){
        //1. Verificar si el usuario desea modificar el nombre de la categoría
        if (nombre.equals(nombreAnt)) {
            //2. Llenar el objeto
            obj.setIdCategoria(id);
            obj.setNombreCategoria(nombre);
            obj.setDescripcionCategoria(descripcion);
            obj.setObservaciones(observaciones);
            obj.setImagenCategoria(imagen);
            
            //3. Actualizar el registro
            if (DATOS.actualizar(obj)){
                return "OK";
            } else {
                return "Error en la actualización del registro";
            }
        } else {
            if (DATOS.existe(nombre)) {
                return "Ya existe la categoría.";
            } else {
                
                obj.setIdCategoria(id);
                obj.setNombreCategoria(nombre);
                obj.setDescripcionCategoria(descripcion);
                obj.setObservaciones(observaciones);
                obj.setImagenCategoria(imagen);
            
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
}
