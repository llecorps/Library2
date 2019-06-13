package org.lle.biblio.consumer.impl.dao;

import org.lle.biblio.consumer.contract.dao.UtilisateurDao;
import org.lle.biblio.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.lle.biblio.model.exception.NotFoundException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

    @Inject
    private UtilisateurRM utilisateurRM;


    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        String vSQL = "SELECT * FROM utilisateur WHERE id = "+pId;
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", pId);
        try {
            Utilisateur vUtilisateur = vJdbcTemplate.queryForObject(vSQL, vParams, utilisateurRM);
            return vUtilisateur;
        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Utilisateur non trouvé. id=" + pId);
        }
    }

    @Override
    public Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException {

        String simpleQuote="'";
        String username = simpleQuote+pLogin+simpleQuote;
        String pass = simpleQuote+pPassword+simpleQuote;

        String vSQL
                = "SELECT * FROM utilisateur"
                + " WHERE login = "+username
                + " AND password = crypt("+pass+",password)";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("login", pLogin);
        vParams.addValue("password", pPassword);

        try {
            Utilisateur vUtilisateur = vJdbcTemplate.queryForObject(vSQL, vParams, utilisateurRM);
            return vUtilisateur;
        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Utilisateur non trouvé. Login=" + pLogin);
        }
    }
}
