/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class SSHKeyAuthProvider extends TokenBasedProvider {

    @Override
    public boolean authenticate(String username, String sshKey) {
        boolean success = sshKey.contains("ssh-rsa");
        AuthLogger.log(username, success);
        if (success) {
            String token = generateToken(username);
            activeTokens.put(username, token);
            System.out.println("🔐 Token SSH asignado: " + token);
        }
        return success;
    }

    @Override
    protected String generateToken(String username) {
        return "SSH-" + username + "-" + System.currentTimeMillis();
    }
    
}
