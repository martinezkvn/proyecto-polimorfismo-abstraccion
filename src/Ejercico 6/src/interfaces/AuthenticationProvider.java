/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public interface AuthenticationProvider {
     boolean authenticate(String username, String credential);

    void logout(String username);

    boolean hasPermission(User user, String permission);
}

