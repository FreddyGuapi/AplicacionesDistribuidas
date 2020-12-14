
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto p=new Producto();
    
    @Override
    public List listar() {
        ArrayList<Producto>list=new ArrayList<>();
        String sql="select * from producto";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto per=new Producto();
                per.setCodigo(rs.getInt("codigo"));
                per.setNombre(rs.getString("nombre"));
                per.setPrecio(rs.getString("precio"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Producto list(int id) {
        String sql="select * from producto where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setCodigo(rs.getInt("Id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getString("precio"));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    public boolean add(Producto per) {
       String sql="insert into producto(nombre, precio)values('"+per.getNombre()+"','"+per.getPrecio()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    public boolean edit(Producto per) {
        String sql="update producto set nombre='"+per.getNombre()+"',precio='"+per.getPrecio()+"'where codigo="+per.getCodigo();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
        
       
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from producto where codigo="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

 
    
}
