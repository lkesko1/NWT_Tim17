package ba.unsa.etf.nwtcinemamovies.dto;

import java.io.Serializable;

public class CreatedUser implements Serializable {
    private String username;
    private String roleTitle;

    public CreatedUser() {
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public CreatedUser(String username, String roleTitle) {
        this.username = username;
        this.roleTitle = roleTitle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
