/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class LDAPAuthProvider extends TokenBasedProvider {

    @Override
    public boolean authenticate(String username, String password) {
        boolean success = password.equals("ldap123");
        AuthLogger.log(username, success);
        if (success) {
            String token = generateToken(username);
            activeTokens.put(username, token);
            System.out.println("Token LDAP asignado: " + token);
        }
        return success;
    }

    @Override
    protected String generateToken(String username) {
        return "LDAP-" + username + "-" + System.currentTimeMillis();
    } 
    
}
