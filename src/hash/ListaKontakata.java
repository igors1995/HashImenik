/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.util.LinkedList;
import kontakt.Kontakt;

/**
 *
 * @author Skilja
 */
public class ListaKontakata {

    LinkedList<Kontakt> lista = new LinkedList<>();

    public void dodajKontakt(Kontakt k) {
        lista.add(k);
    }

    public LinkedList<Kontakt> nadjiKontakt(String ime) {
        LinkedList<Kontakt> k = new LinkedList<>();

        for (Kontakt kontakt : lista) {
            if (kontakt.getIme().equals(ime)) {
                k.add(kontakt);
            }
        }
        return k;
    }
}
