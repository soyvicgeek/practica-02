package datos;

import database.Conexion;
import datos.interfaces.CrudPaginadoInterface;
import entidades.Productos;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductoDAO implements CrudPaginadoInterface<Productos> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public ProductoDAO() {
        CON = new Conexion("VideoGames", "root", "123", "jdbc:mysql://localhost:3306/");
    }

    @Override
    public List<Productos> listar(String texto, int totalPorPagina, int numPagina) {
        List<Productos> registros = new ArrayList();
        String sql;
        try{
            sql="SELECT P.idProducto, C.idCategoria, C.nombreCategoria, S.idSubcategoria, S.nombreSubcategoria,\n" +
                "P.nombreProducto, P.precioProducto, P.descuentoProducto, P.existenciaProducto, P.tipoProducto,\n" +
                "P.imagenProducto, P.codigoQR, P.estado\n" +
                "FROM Productos P, Categorias C, Subcategorias S\n" +
                "WHERE S.idSubcategoria = P.idSubcategoria AND P.idCategoria = C.idCategoria AND\n" +
                "P.nombreProducto LIKE ? ORDER BY P.idProducto LIMIT ?,?";
            ps=CON.conectar().prepareStatement(sql);
            ps.setString(1, "%"+texto+"%"); //texto = 'nin' --> '%nin%'
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            
            rs=ps.executeQuery();
            while(rs.next()) {
                
                registros.add(new Productos(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getBoolean(13)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
    //Método que regrese los datos de un producto
    public Productos obtenerProducto(int productoID) {
        Productos prod = null;      
        String sql;
        try{
            sql="SELECT idProducto, nombreProducto, precioProducto, existenciaProducto FROM Productos WHERE idProducto = ?";
            ps=CON.conectar().prepareStatement(sql);
            ps.setInt(1, productoID);
            
            rs=ps.executeQuery();
            if(rs.next()) {
                prod = new Productos(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
            }
            ps.close();
            rs.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return prod;
    }

    @Override
    public boolean insertar(Productos obj) {
        String sql;
        resp=false;
        try{
            sql="INSERT INTO Productos() VALUES( null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setInt(1, obj.getIdCategoria());
            ps.setInt(2, obj.getIdSubcategoria());
            ps.setString(3, obj.getNombreProducto());
            ps.setFloat(4, obj.getPrecioProducto());
            ps.setInt(5, obj.getDescuentoProducto());
            ps.setInt(6, obj.getExistenciaProducto());
            ps.setString(7, obj.getTipoProducto());
            ps.setString(8, obj.getImagenProducto());
            ps.setString(9, obj.getCodigoQR());
            ps.setBoolean(10, obj.isEstado());
            
            //Verificar si se inserto el registro
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            
            ps.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Productos obj) {
        String sql;
        resp=false;
        try{
            sql="UPDATE Productos SET nombreProducto = ?, precioProducto = ?, descuentoProducto = ?,"
                    + "existenciaProducto = ?, tipoProducto = ?, imagenProducto = ?, codigoQR = ?, idCategoria = ?, idSubCategoria = ? WHERE idProducto = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setString(1, obj.getNombreProducto());
            ps.setFloat(2, obj.getPrecioProducto());
            ps.setInt(3, obj.getDescuentoProducto());
            ps.setInt(4, obj.getExistenciaProducto());
            ps.setString(5, obj.getTipoProducto());
            ps.setString(6, obj.getImagenProducto());
            ps.setString(7, obj.getCodigoQR());
            ps.setInt(8, obj.getIdCategoria());
            ps.setInt(9, obj.getIdSubcategoria());
            ps.setInt(10, obj.getIdProducto());
            
            //Verificar si se inserto el registro
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            
            ps.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        String sql;
        resp=false;
        try{
            sql="UPDATE Productos SET estado = 0 WHERE idProducto = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setInt(1,id);
            
            //Verificar si se inserto el registro
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            
            ps.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        String sql;
        resp=false;
        try {
            sql="UPDATE Productos SET estado = 1 WHERE idProducto = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //rs=ps.executeQuery();
            //PASAR LOS VALORES A LAS CONSULTA
            ps.setInt(1, id);
   
            //Verifiacr si se inserto el registro
            if(ps.executeUpdate()>0)
            {
                resp=true;
            }
            ps.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        String sql;
        int totalRegistros=0;
        try {
            sql="SELECT COUNT(idProducto) as numRegistros FROM Productos";
            ps=CON.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next())    
                totalRegistros=rs.getInt("numRegistros");
            
            ps.close();
        }catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        String sql;
        resp=false;
        try {
            sql="SELECT idProducto FROM Productos WHERE nombreProducto = ?";
            
            ps = CON.conectar().prepareStatement(sql);
            
            ps.setString(1, texto);
            rs = ps.executeQuery();
            //rs.last();
            if(rs.next())
            {
                resp=true;
            }
        ps.close();
        rs.close();       
        }
        catch(SQLException e)
                {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
        finally
        {
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
    
}
