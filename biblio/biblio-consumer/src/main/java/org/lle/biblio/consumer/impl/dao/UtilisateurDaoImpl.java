package org.lle.biblio.consumer.impl.dao;

import org.lle.biblio.consumer.contract.dao.UtilisateurDao;
import org.lle.biblio.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import org.lle.biblio.model.bean.utilisateur.Utilisateur;
import org.lle.biblio.model.exception.NotFoundException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;


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
    public void delRecall(int id) {

        String vSQL = "update utilisateur set recall=FALSE WHERE id="+id+";COMMIT;";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", id, Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParams);

    }

    @Override
    public void addRecall(int id) {

        String vSQL = "update utilisateur set recall=TRUE WHERE id="+id+";COMMIT;";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", id, Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParams);

    }

    @Override
    public boolean getRecall(int id) {

        String vSQL = "SELECT recall FROM utilisateur WHERE id = "+id;

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);

        boolean vRecall = vJdbcTemplate.queryForObject(vSQL, vParams, boolean.class);

        return vRecall;
    }

    @Override
    public List<Utilisateur> listRecall() {

        String vSQL = "SELECT * FROM utilisateur WHERE recall=TRUE";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Utilisateur> vRowMapper = new UtilisateurRM();

        List<Utilisateur> vListRecall = vJdbcTemplate.query(vSQL, vRowMapper);
        return vListRecall;

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
