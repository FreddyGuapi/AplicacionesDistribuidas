
package Intefaces;

import Modelo.Producto;
import java.util.List;


public interface CRUD {
    public List listar();
    public Producto list(int id);
    public boolean add(Producto per);
    public boolean edit(Producto per);
    public boolean eliminar(int id);
}
