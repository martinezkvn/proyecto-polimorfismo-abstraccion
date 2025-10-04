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
public abstract class TokenBasedProvider implements AuthenticationProvider {

    protected Map<String, String> activeTokens = new HashMap<>();

    protected abstract String generateToken(String username);

    @Override
    public void logout(String username) {
        activeTokens.remove(username);
        System.out.println("Sesión cerrada para: " + username);
    }

    @Override
    public boolean hasPermission(User user, String permission) {
        return user.getRole().getPermissions().contains(permission);
    }
}
