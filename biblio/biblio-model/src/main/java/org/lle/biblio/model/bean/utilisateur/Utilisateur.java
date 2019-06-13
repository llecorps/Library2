package org.lle.biblio.model.bean.utilisateur;

/**
 * Classe représentant un Utilsateur
 */
public class Utilisateur {

    // ==================== Attributs ====================
    private int id;
    private String login;
    private String email;
    private String password;
    private String adress;
    private String phone;




    // ==================== Constructeurs ====================

    public Utilisateur(int id, String login, String email, String password, String adress, String phone) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.adress = adress;
        this.phone = phone;
    }


    public Utilisateur() {
    }
// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    // ==================== Méthodes ====================

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
