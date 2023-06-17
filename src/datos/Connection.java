package datos;

import database.Conexion;

public class Connection {
    private final Conexion CON;
    
    public Connection() {
        CON = new Conexion("VideoGames", "root", "123", "jdbc:mysql://localhost:3306/");
    }
    
}
