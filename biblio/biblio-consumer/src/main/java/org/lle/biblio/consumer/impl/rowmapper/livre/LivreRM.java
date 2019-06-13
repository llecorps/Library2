package org.lle.biblio.consumer.impl.rowmapper.livre;

import org.lle.biblio.model.bean.livre.Livre;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TheAdmin on 30.01.2019.
 */
@Named
public class LivreRM implements RowMapper<Livre> {

    public Livre mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Livre vLivre = new Livre();
        vLivre.setId(pRS.getInt("id"));
        vLivre.setTitre(pRS.getString("titre"));
        vLivre.setDescription(pRS.getString("description"));
        vLivre.setAuteur_id(pRS.getInt("auteur_id"));
        vLivre.setGenre(pRS.getString("genre"));
        vLivre.setExemplaire(pRS.getInt("exemplaire"));


        return vLivre;
    }


}
