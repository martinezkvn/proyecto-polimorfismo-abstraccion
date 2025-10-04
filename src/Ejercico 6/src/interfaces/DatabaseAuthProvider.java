/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class DatabaseAuthProvider extends TokenBasedProvider {

    private Map<String, String> usersDB = new HashMap<>();

    public DatabaseAuthProvider() {
        usersDB.put("admin", "admin123");
        usersDB.put("user", "user123");
    }

    @Override
    public boolean authenticate(String username, String password) {
        boolean success = usersDB.containsKey(username) && usersDB.get(username).equals(password);
        AuthLogger.log(username, success);
        if (success) {
            String token = generateToken(username);
            activeTokens.put(username, token);
            System.out.println("💾 Token DB asignado: " + token);
        }
        return success;
    }

    @Override
    protected String generateToken(String username) {
        return "DB-" + username + "-" + System.currentTimeMillis();
    }
}
