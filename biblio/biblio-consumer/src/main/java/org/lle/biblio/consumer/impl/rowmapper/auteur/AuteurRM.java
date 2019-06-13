package org.lle.biblio.consumer.impl.rowmapper.auteur;


import org.lle.biblio.model.bean.auteur.Auteur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TheAdmin on 31.01.2019.
 */
@Named
public class AuteurRM implements RowMapper<Auteur> {

    public Auteur mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Auteur vAuteur = new Auteur();
        vAuteur.setId(pRS.getInt("id"));
        vAuteur.setPrenom(pRS.getString("prenom"));
        vAuteur.setNom(pRS.getString("nom"));
        vAuteur.setGenre(pRS.getString("genre"));

        return vAuteur;
    }
}
