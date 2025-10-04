
package interfaces;

import java.time.LocalDateTime;

public class AuthLogger {
    public static void log(String username, boolean success) {
        String status = success ? "ÉXITO" : "FALLIDO";
        System.out.println(LocalDateTime.now() + " | Usuario: " + username + " | Resultado: " + status);
    }
}
