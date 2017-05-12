/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import baza.Baza;
import java.util.LinkedList;
import kontakt.Kontakt;

/**
 *
 * @author Skilja
 */
public class HashTable {

    ListaKontakata[] niz;

    public HashTable() {
        this.niz = new ListaKontakata[150];
    }

    public int hashF(String ime) {
        int a = 0;

        for (int i = 0; i < ime.length(); i++) {
            a = ((a * 127 + ime.charAt(i)) % 558319);
        }

        return (a % (niz.length + 1));
    }

    public void ubaciUNiz(Kontakt k) {
        
        int mesto = hashF(k.getIme());
        if (niz[mesto] == null) {
            niz[mesto] = new ListaKontakata();
        }
        niz[mesto].dodajKontakt(k);
    }

    public LinkedList<Kontakt> izvadiIzNiza(String ime) {
        return niz[hashF(ime)].nadjiKontakt(ime);
    }
    public LinkedList<Kontakt> izvuciSve(String user){
        LinkedList<Kontakt> kontakti = Baza.ucitajSveIzBaze(user);
        
        
        
        return kontakti;
    }
//    public static void ispisi(LinkedList<Kontakt> k){
//        for (Kontakt kontakt : k) {
//            System.out.println(kontakt.getIme() + "  " + kontakt.getBroj());
//        }
//    }
//    
//    public static void main(String[] args) {
//        HashTable ht = new HashTable();
//        Kontakt k = new Kontakt("Edis", "064123451");
//        Kontakt k1 = new Kontakt("Marko", "064221333");
//        Kontakt k3 = new Kontakt("Marko", "0112255444");
//        ht.ubaciUNiz(k);
//        ht.ubaciUNiz(k1);
//        ht.ubaciUNiz(k3);
//        
//        HashTable.ispisi(ht.izvadiIzNiza("Edis"));
//        HashTable.ispisi(ht.izvadiIzNiza("Marko"));
//    }
}
