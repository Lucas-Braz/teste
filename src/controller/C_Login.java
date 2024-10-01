package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import service.S_Generic;
import service.S_Login;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class C_Login implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();

        if(method.equalsIgnoreCase("GET")){
            File file = new File("C:\\Users\\lucas38071\\Desktop\\LoginPuro\\src\\view\\index.html");
            S_Generic.returnPage(file,exchange);
        }else if(method.equalsIgnoreCase("POST")){
            Map<String, String> params = S_Generic.getPostParameters(new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
            String usuario = params.getOrDefault("usuario", "");
            String senha = params.getOrDefault("senha", "");

            File file;
            if(S_Login.validaLogin(usuario,senha)){
                file = new File("C:\\Users\\lucas38071\\Desktop\\LoginPuro\\src\\view\\home.html");
            }else{
                file = new File("C:\\Users\\lucas38071\\Desktop\\LoginPuro\\src\\view\\index.html");
            }
            S_Generic.returnPage(file,exchange);
        }
    }
}
