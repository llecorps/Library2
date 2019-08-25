package org.lle.biblio.consumer.impl.rowmapper.utilisateur;

import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;


@Named
public class UtilisateurRM implements RowMapper<Utilisateur> {

    @Override
    public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        Utilisateur vUtilisateur = new Utilisateur();
        vUtilisateur.setId(pRS.getInt("id"));
        vUtilisateur.setLogin(pRS.getString("login"));
        vUtilisateur.setEmail(pRS.getString("email"));
        vUtilisateur.setPassword(pRS.getString("password"));
        vUtilisateur.setAdress(pRS.getString("adress"));
        vUtilisateur.setPhone(pRS.getString("phone"));
        vUtilisateur.setRecall(pRS.getBoolean("recall"));

        return  vUtilisateur;
    }
}
