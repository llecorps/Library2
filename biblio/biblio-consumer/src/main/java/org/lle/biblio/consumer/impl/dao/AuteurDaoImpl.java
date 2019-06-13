package org.lle.biblio.consumer.impl.dao;

import org.lle.biblio.consumer.contract.dao.AuteurDao;
import org.lle.biblio.consumer.impl.rowmapper.auteur.AuteurRM;
import org.lle.biblio.model.bean.auteur.Auteur;
import org.lle.biblio.model.exception.NotFoundException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by TheAdmin on 31.01.2019.
 */
@Named
public class AuteurDaoImpl extends AbstractDaoImpl implements AuteurDao {

    @Inject
    private AuteurRM auteurRM;

    @Override
    public Auteur getAuteur(int pId) throws NotFoundException {
        String vSQL = "SELECT * FROM auteur WHERE id ="+pId;
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", pId);
        try {
            Auteur vAuteur = vJdbcTemplate.queryForObject(vSQL, vParams, auteurRM);
            return vAuteur;

        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Auteur non trouvé id=" + pId);
        }
    }
}
