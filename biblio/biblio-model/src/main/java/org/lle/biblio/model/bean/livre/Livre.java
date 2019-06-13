package org.lle.biblio.model.bean.livre;

/**
 * Created by TheAdmin on 13.01.2019.
 */
public class Livre {

    private int id;
    private String titre;
    private int auteur_id;
    private int exemplaire;
    private String description;
    private String genre;

    public Livre() {
    }

    public Livre(int id, String titre, int auteur_id, int exemplaire, String description, String genre) {
        this.id = id;
        this.titre = titre;
        this.auteur_id = auteur_id;
        this.exemplaire = exemplaire;
        this.description = description;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAuteur_id() {
        return auteur_id;
    }

    public void setAuteur_id(int auteur_id) {
        this.auteur_id = auteur_id;
    }

    public int getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(int exemplaire) {
        this.exemplaire = exemplaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur_id=" + auteur_id +
                ", exemplaire='" + exemplaire + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
