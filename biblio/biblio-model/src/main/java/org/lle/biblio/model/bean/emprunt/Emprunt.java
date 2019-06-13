package org.lle.biblio.model.bean.emprunt;

/**
 * Created by TheAdmin on 16.02.2019.
 */
public class Emprunt {

    private String titre;
    private String description;
    private String genre;
    private String expiredate;
    private String nom;
    private String prolongation;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProlongation() {
        return prolongation;
    }

    public void setProlongation(String prolongation) {
        this.prolongation = prolongation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Emprunt() {
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", expiredate='" + expiredate + '\'' +
                ", nom='" + nom + '\'' +
                ", prolongation='" + prolongation + '\'' +
                ", id=" + id +
                '}';
    }
}
