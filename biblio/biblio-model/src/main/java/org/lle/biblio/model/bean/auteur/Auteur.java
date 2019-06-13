package org.lle.biblio.model.bean.auteur;

/**
 * Created by TheAdmin on 13.01.2019.
 */
public class Auteur {

    private int id;
    private String prenom;
    private String nom;
    private String genre;

    public Auteur() {
    }

    public Auteur(int id, String prenom, String nom, String genre) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
