
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    public Connection c;
    private static final String URL = "jdbc:mysql://localhost:3306/BD_eventos";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public ConexaoBanco() {
        this.c = null;
        try {
            this.c = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Falha na conexão com o Banco de Dados: " + e.getMessage());
        }
    }
}
