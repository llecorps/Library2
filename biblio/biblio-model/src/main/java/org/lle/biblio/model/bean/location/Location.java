package org.lle.biblio.model.bean.location;

/**
 * Created by TheAdmin on 13.01.2019.
 */
public class Location {

    private int id;
    private int utilisateur_id;
    private int livre_id;
    private String expiredate;
    private boolean prolongation;

    public Location() {
    }

    public Location(int id, int utilisateur_id, int livre_id, String expiredate, boolean prolongation) {
        this.id = id;
        this.utilisateur_id = utilisateur_id;
        this.livre_id = livre_id;
        this.expiredate = expiredate;
        this.prolongation = prolongation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getLivre_id() {
        return livre_id;
    }

    public void setLivre_id(int livre_id) {
        this.livre_id = livre_id;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }

    public boolean isProlongation() {
        return prolongation;
    }

    public void setProlongation(boolean prolongation) {
        this.prolongation = prolongation;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", utilisateur_id=" + utilisateur_id +
                ", livre_id=" + livre_id +
                ", expiredate='" + expiredate + '\'' +
                ", prolongation=" + prolongation +
                '}';
    }
}
