package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.M_Usuario;
import service.S_Cadastro;
import service.S_Generic;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class C_Cadastro implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();

        if(method.equalsIgnoreCase("GET")){
            File file = new File("C:\\Users\\lucas38071\\Desktop\\LoginPuro\\src\\view\\cadastro.html");
            S_Generic.returnPage(file,exchange);
        }else if(method.equalsIgnoreCase("POST")){
            Map<String, String> params = S_Generic.getPostParameters(new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
            String usuario = params.getOrDefault("usuario", "");
            String apelido = params.getOrDefault("nick", "");
            String senha = params.getOrDefault("senha","");
            String confSenha = params.getOrDefault("confSenha","");
            M_Usuario m_usuario = S_Cadastro.cadastrarUsuario(usuario,apelido,senha,confSenha);
            File file;
            if(m_usuario != null){
                file = new File("C:\\Users\\lucas38071\\Desktop\\LoginPuro\\src\\view\\index.html");
            }else{
                file = new File("C:\\Users\\lucas38071\\Desktop\\LoginPuro\\src\\view\\cadastro.html");
            }
            S_Generic.returnPage(file, exchange);
        }
    }
}
