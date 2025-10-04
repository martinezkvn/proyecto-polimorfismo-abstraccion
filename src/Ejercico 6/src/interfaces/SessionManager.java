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
public class SessionManager {
    private Map<String, String> sessions = new HashMap<>();

    public void createSession(String username, String token) {
        sessions.put(username, token);
        System.out.println("Sesión iniciada para: " + username);
    }

    public void endSession(String username) {
        sessions.remove(username);
    }

    public boolean isActive(String username) {
        return sessions.containsKey(username);
    }
}

