/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class OAuth2Provider extends TokenBasedProvider {

    @Override
    public boolean authenticate(String username, String oauthToken) {
        boolean success = oauthToken.startsWith("oauth-");
        AuthLogger.log(username, success);
        if (success) {
            String token = generateToken(username);
            activeTokens.put(username, token);
            System.out.println("🌐 Token OAuth2 asignado: " + token);
        }
        return success;
    }

    @Override
    protected String generateToken(String username) {
        return "OAUTH2-" + username + "-" + System.currentTimeMillis();
    } 
    
}
