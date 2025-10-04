/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.Objects;
import javax.management.relation.Role;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class User {
    private String username;
    private String password;
    private Role role;
    private boolean mfaEnabled;

    public User(String username, String password, Role role, boolean mfaEnabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.mfaEnabled = mfaEnabled;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }
    public boolean isMfaEnabled() { return mfaEnabled; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
