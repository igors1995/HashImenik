/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Skilja
 */
public class User {
    String username;
    String password;

    public User(String username, String pasword) {
        this.username = username;
        this.password = pasword;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    
    
}
