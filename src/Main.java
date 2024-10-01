import com.sun.net.httpserver.HttpServer;
import controller.C_Cadastro;
import controller.C_Login;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
        server.createContext("/", new C_Login());
        server.createContext("/cadastrar", new C_Cadastro());
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado na porta 8080");
    }
}
