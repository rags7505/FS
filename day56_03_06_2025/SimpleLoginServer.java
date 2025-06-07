import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SimpleLoginServer {

    public static void main(String[] args) throws IOException {
        // Create the HTTP server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/api/employees", new LoginHandler());
        server.setExecutor(null); // creates a default executor
        System.out.println("Server started on port 8000...");
        server.start();
    }

    static class LoginHandler implements HttpHandler {

        private static final String VALID_USERNAME = "admin";
        private static final String VALID_PASSWORD = "admin";

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();

            if (!method.equalsIgnoreCase("POST")) {
                // Method not allowed
                String response = "Only POST method is supported";
                exchange.sendResponseHeaders(405, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes(StandardCharsets.UTF_8));
                }
                return;
            }

            // Read request body
            InputStream inputStream = exchange.getRequestBody();
            byte[] data = inputStream.readAllBytes();
            String body = new String(data, StandardCharsets.UTF_8);

            // Parse form data
            Map<String, String> params = parseFormData(body);
            String username = params.get("username");
            String password = params.get("password");

            // Validate credentials
            if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
                String response = "Login successful";
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes(StandardCharsets.UTF_8));
                }
            } else {
                String response = "Invalid credentials";
                exchange.sendResponseHeaders(401, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes(StandardCharsets.UTF_8));
                }
            }
        }

        private Map<String, String> parseFormData(String body) {
            Map<String, String> map = new HashMap<>();
            String[] pairs = body.split("&");
            for (String pair : pairs) {
                String[] kv = pair.split("=", 2);
                if (kv.length == 2) {
                    map.put(kv[0], kv[1]);
                }
            }
            return map;
        }
    }
}
