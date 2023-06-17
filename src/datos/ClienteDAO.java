package datos;

import database.Conexion;
import entidades.Cliente;
import entidades.Productos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public ClienteDAO() {
        CON = new Conexion("VideoGames", "root", "123", "jdbc:mysql://localhost:3306/");
    }
    
    public Cliente Buscar(int id) {
        Cliente cliente = null;
        String sql;
        try{
            sql="select * from clientes where idCliente = "+id;
            ps=CON.conectar().prepareStatement(sql);
            
            rs=ps.executeQuery();
            if(rs.next()) {
                
                cliente = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
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
        return cliente;
    }
}
