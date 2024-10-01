package service;

import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class S_Generic {
    public static void returnPage(File file,HttpExchange exchange) throws IOException {
        if(file.exists()){
            exchange.sendResponseHeaders(200,file.length());
            OutputStream os = exchange.getResponseBody();
            Files.copy(file.toPath(),os);
            os.close();
        }else{
            String response = "Página não encontrada :(";
            exchange.sendResponseHeaders(404, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static Map<String, String> getPostParameters(String parametros) {
        Map<String, String> result = new HashMap<>();
        for (String param : parametros.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }
}
