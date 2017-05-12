/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author Skilja
 */
public class Konekcija {
    public static final String bazaKontakti = "jdbc:mysql://localhost:3306/imenik";
    public static final String bazaUseri = "jdbc:mysql://localhost:3306/user_imenik"; 
    
    
    public Konekcija() {
    }

    public static Connection getConnection(String baza) {
        Connection konekcija = null;
        try {

            konekcija = DriverManager.getConnection(baza, "root", "");
            //DODAJ NAZIV TABELE!!!

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Neuspesna konekcija");
        }
        return konekcija;
    }
}
