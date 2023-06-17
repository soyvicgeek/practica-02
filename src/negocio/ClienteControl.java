package negocio;

import datos.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteControl {
    private final ClienteDAO DATOS;
    private Cliente obj;
    
    public ClienteControl() {
        DATOS = new ClienteDAO();
        obj = new Cliente();
    }
    
    public Cliente Buscar(int id) {
        return DATOS.Buscar(id);
    }
    
}
