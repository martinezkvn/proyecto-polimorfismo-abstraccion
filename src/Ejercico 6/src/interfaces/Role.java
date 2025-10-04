/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.List;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class Role {
    private String name;
    private List<String> permissions;

    public Role(String name, List<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() { return name; }
    public List<String> getPermissions() { return permissions; }
}
