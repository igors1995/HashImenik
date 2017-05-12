/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import user.User;
import hash.HashTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontakt.Kontakt;

public class Baza {

    public static void dodajKontaktUBazu(Kontakt k) {
        Connection c;

        try {
            c = Konekcija.getConnection(Konekcija.bazaKontakti);
            Statement s = c.createStatement();

            String SQL = "INSERT INTO imenik"
                    + "(ime , broj , username) "
                    + "VALUES" + "('" + k.getIme() + "' , '" + k.getBroj() + "' , '"   + k.getUsername() + "')";
            System.out.println(SQL);
            s.executeUpdate(SQL);

            s.close();
            c.close();
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje u bazu!");
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static HashTable ucitajIzBaze(String baza, String korisnik) {
        HashTable ht = new HashTable();

        try {

            Connection c = Konekcija.getConnection(baza);
            Statement s = c.createStatement();

            String SQL = "SELECT ime, broj,  username FROM imenik";

            ResultSet rs = s.executeQuery(SQL);
            while (rs.next()) {
                String ime = rs.getString("ime");
                String broj = rs.getString("broj");
                String username = rs.getString("username");
                if (username.equals(korisnik)) {
                    ht.ubaciUNiz(new Kontakt(ime, broj, username));
                }
            }
            s.close();
            c.close();
            return ht;
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ht;
    }

    public static LinkedList<Kontakt> ucitajSveIzBaze(String user) {
        LinkedList<Kontakt> kontakti = new LinkedList<>();

        try {

            Connection c = Konekcija.getConnection(Konekcija.bazaKontakti);
            Statement s = c.createStatement();

            String SQL = "SELECT ime, broj, username FROM imenik";

            ResultSet rs = s.executeQuery(SQL);

            while (rs.next()) {
                String ime = rs.getString("ime");
                String broj = rs.getString("broj");
                String username = rs.getString("username");
                if(username.equals(user)){
                kontakti.add(new Kontakt(ime, broj, username));
            }}

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kontakti;

    }

    public static LinkedList<User> ucitajUsereIzBaze() {
        LinkedList<User> useri = new LinkedList<User>();

        try {

            Connection c = Konekcija.getConnection(Konekcija.bazaUseri);
            Statement s = c.createStatement();

            String SQL = "SELECT username, password FROM user";

            ResultSet rs = s.executeQuery(SQL);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                useri.add(new User(username, password));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return useri;

    }

    public static User proveriDaLiJeUserUBazi(String username) {
        LinkedList<User> useri = ucitajUsereIzBaze();

        for (User user : useri) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void dodajUseraUBazu(User u) {
        Connection c;

        try {
            c = Konekcija.getConnection(Konekcija.bazaUseri);
            Statement s = c.createStatement();

            String SQL = "INSERT INTO user"
                    + "(username, password) "
                    + "VALUES" + "('" + u.getUsername() + "', '" + u.getPassword() + "')";
            System.out.println(SQL);
            s.executeUpdate(SQL);

            s.close();
            c.close();
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje u bazu!");
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
