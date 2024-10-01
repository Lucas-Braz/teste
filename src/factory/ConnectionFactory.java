package factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // Configurações do banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/jogis";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123";

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() {
        try {
            // Registra o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Retorna a conexão
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            // Trata exceções
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erro ao fechar conexão com o banco de dados", e);
            }
        }
    }
}
