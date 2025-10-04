/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import interfaces.AuthenticationProvider;
import interfaces.DatabaseAuthProvider;
import interfaces.OAuth2Provider;
import interfaces.SSHKeyAuthProvider;
import interfaces.SessionManager;
import interfaces.User;
import java.util.Arrays;
import javax.management.relation.Role;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Role adminRole = new Role("Administrador", Arrays.asList("READ", "WRITE", "DELETE"));
        Role userRole = new Role("Usuario", Arrays.asList("READ"));

        User admin = new User("admin", "admin123", adminRole, true);
        User user = new User("user", "user123", userRole, false);

        SessionManager sessionManager = new SessionManager();


        AuthenticationProvider dbAuth = new DatabaseAuthProvider();
        AuthenticationProvider ldapAuth = new LDAPAuthProvider();
        AuthenticationProvider oauthAuth = new OAuth2Provider();
        AuthenticationProvider sshAuth = new SSHKeyAuthProvider();

        System.out.println("=== AUTENTICACIÓN DB ===");
        if (dbAuth.authenticate(admin.getUsername(), admin.getPassword())) {
            sessionManager.createSession(admin.getUsername(), "token-db");
        }

        System.out.println("\n=== AUTENTICACIÓN LDAP ===");
        ldapAuth.authenticate(user.getUsername(), "ldap123");

        System.out.println("\n=== AUTENTICACIÓN OAUTH2 ===");
        oauthAuth.authenticate("googleUser", "oauth-abc123");

        System.out.println("\n=== AUTENTICACIÓN SSH ===");
        sshAuth.authenticate("devops", "ssh-rsa AAAAB3Nza...");

  
        System.out.println("\n¿Admin puede eliminar? " + dbAuth.hasPermission(admin, "DELETE"));
        System.out.println("¿Usuario puede eliminar? " + dbAuth.hasPermission(user, "DELETE"));
    }    
}
    

