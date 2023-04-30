package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Categorias;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CategoriaDAO implements CrudSimpleInterface<Categorias> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public CategoriaDAO() {
        CON = new Conexion("VideoGames", "root", "123", "jdbc:mysql://localhost:3306/");
    }

    @Override
    public List<Categorias> listar(String texto) {
        List<Categorias> registros = new ArrayList();
        String sql;
        try{
            sql="SELECT * FROM categorias";
            ps=CON.conectar().prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                registros.add(new Categorias(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBoolean(6)));
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

    @Override
    public boolean insertar(Categorias obj) {
        String sql;
        resp=false;
        try{
            sql="INSERT INTO categorias (nombreCategoria, imagenCategoria, descripcionCategoria, observaciones, activo) VALUES (?,?,?,?,?)";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setString(1, obj.getNombreCategoria());
            ps.setString(2, obj.getImagenCategoria());
            ps.setString(3, obj.getDescripcionCategoria());
            ps.setString(4, obj.getObservaciones());
            ps.setBoolean(5, obj.isActivo());
            
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
    public boolean actualizar(Categorias obj) {
        String sql;
        resp=false;
        try{
            sql="UPDATE Categorias SET nombreCategoria = ?, imagenCategoria = ?, descripcionCategoria = ?, observaciones = ? WHERE idCategoria = ?";
            ps=CON.conectar().prepareStatement(sql);
            
            //Pasar los valores a la consulta sql
            ps.setString(1, obj.getNombreCategoria());
            ps.setString(2, obj.getImagenCategoria());
            ps.setString(3, obj.getDescripcionCategoria());
            ps.setString(4, obj.getObservaciones());
            ps.setInt(5, obj.getIdCategoria());
            
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
            sql="UPDATE Categorias SET activo = 0 WHERE idCategoria = ?";
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
            sql="UPDATE Categorias SET activo = 1 WHERE idCategoria = ?";
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
        return resp;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int total() {
        String sql;
        int totalRegistros=0;
        try
        {
    sql="SELECT COUNT(idCategoria) as numRegistros FROM Categorias ";
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
            sql="SELECT idCategoria FROM Categorias WHERE nombreCategoria = ?";
            
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
