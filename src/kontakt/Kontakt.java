/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontakt;

/**
 *
 * @author Skilja
 */
public class Kontakt {
    String ime;
    String broj;
    String username;

    public Kontakt(String ime, String broj, String username) {
        this.ime = ime;
        this.broj = broj;
        this.username = username; 
             
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    @Override
    public String toString() {
        return ("Ime: " + ime + ", Broj: " + broj);
    }

    
}
