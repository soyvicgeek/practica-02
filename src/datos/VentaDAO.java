package datos;

import database.Conexion;
import entidades.DetalleVenta;
import entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentaDAO {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public VentaDAO() {
        CON = new Conexion("VideoGames", "root", "123", "jdbc:mysql://localhost:3306/");
    }
    
    //Metodo Listar
    public List<Venta> listar(String texto, int totalPorPagina, int numPagina) {
        List<Venta> registros = new ArrayList();
        String sql;
        try{
            sql="Select V.idVenta, C.idCliente, concat(C.nombre, ' ', C.apellidos) as Cliente, V.fecha, V.total, V.iva, V.estado\n" +
                "FROM Ventas V INNER JOIN Clientes C ON C.idCliente = V.idCliente\n" +
                "WHERE V.idVenta like ? ORDER BY V.idVenta ASC LIMIT ?,?;";
            ps=CON.conectar().prepareStatement(sql);
            ps.setString(1, "%"+texto+"%"); //texto = 'nin' --> '%nin%'
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            
            rs=ps.executeQuery();
            while(rs.next()) {
                
                registros.add(new Venta(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDouble(5), rs.getDouble(6), rs.getString(7)));
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
    
    //Método para insertar una Venta
    public boolean insertar(Venta obj) {
        String sql;
        resp=false;
        //La variable de conn se utilizara para realizar las transacciones de forma manual
        Connection conn = null;
        try{
            conn = CON.conectar();
            conn.setAutoCommit(false);
            sql="INSERT INTO Ventas(idCliente,fecha,total,iva,estado)";
            sql = sql+"VALUES(?,now(),?,?,?)";
            ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            //Pasar los valores a la consulta sql
            ps.setInt(1, obj.getIdCliente());
            ps.setDouble(2, obj.getTotal());
            ps.setDouble(3, obj.getIva());
            ps.setString(4, "Aceptado");
            //Ejecutamos la consulta y guardamos el número de filas Aceptadas
            int filasAfectadas = ps.executeUpdate();
            int idVentaGenerado = 0;
            //Obtener el ID Venta
            rs = ps.getGeneratedKeys();
            
            //Asignar el número d eventa generado
            if (rs.next()){
                idVentaGenerado = rs.getInt(1);
            }
            if(filasAfectadas == 1) {
                //Asignar los detalles
                String sqlDetalles = "INSERT INTO detalleventas(idVenta, idProducto,cantidad,precio,descuento)";
                sqlDetalles +="VALUES(?,?,?,?,?)";
                ps = conn.prepareStatement(sqlDetalles);
                //Ciclo for para recorrer los detalles
                for(DetalleVenta item:obj.getDetalles()){
                    ps.setInt(1, idVentaGenerado);
                    ps.setInt(2, item.getIdProducto());
                    ps.setInt(3, item.getCantidad());
                    ps.setDouble(4, item.getPrecio());
                    ps.setDouble(5, item.getDescuento());
                    
                    //Insertar el detalle y vamos a verificar
                    if(ps.executeUpdate() > 0) {
                        resp = true;
                    }
                }
                
                //Cometer la transacción
                conn.commit();
            } else {
                //Oocurrio un error, deshacer la operación
                conn.rollback();
            }
        }catch(SQLException e) {
            try {
                if(conn!=null){
                    conn.rollback();
                }  
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();        
                if(conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }
    
    public DetalleVenta obtenerVenta(int ventaID) {
        DetalleVenta venta = null;      
        String sql;
        try{
            sql="select dv.idProducto, dv.cantidad, p.nombreproducto\n" +
                "from detalleventas dv, productos p\n" +
                "where dv.idProducto=p.idProducto and idVenta= ? ";
            ps=CON.conectar().prepareStatement(sql);
            ps.setInt(1, ventaID);
            
            rs=ps.executeQuery();
            if(rs.next()) {
                //venta = new DetalleVenta(rs.getInt(1),rs.getInt(2),rs.getString(3));
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
        return venta;
    }
    
    //Método para cancelar una venta
    public boolean cancelarVenta(int VentaID) {
        String sql;
        resp=false;
        try{
            sql="UPDATE Ventas SET estado = 'Cancelada' WHERE idVenta = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setInt(1,VentaID);
            
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
}
