package org.lle.biblio.consumer.impl.dao;

import org.lle.biblio.consumer.contract.dao.LivreDao;
import org.lle.biblio.consumer.impl.rowmapper.livre.LivreRM;
import org.lle.biblio.model.bean.livre.Livre;
import org.lle.biblio.model.exception.NotFoundException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by TheAdmin on 30.01.2019.
 */
@Named
public class LivreDaoImpl extends AbstractDaoImpl implements LivreDao {

    @Inject
    private LivreRM livreRM;

    @Override
    public Livre getLivre(int pId) throws NotFoundException {

        String vSQL = "SELECT * FROM livre WHERE id ="+pId;
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", pId);
        try {
            Livre vLivre = vJdbcTemplate.queryForObject(vSQL, vParams, livreRM);
            return vLivre;

        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Livre non trouvé id=" + pId);
        }
    }

    @Override
    public List<Livre> getListLivre() throws NotFoundException {
        String vSQL = "SELECT * FROM livre";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Livre> vRowMapper = new LivreRM();

        List<Livre> vList = vJdbcTemplate.query(vSQL, vRowMapper);
        return vList;
    }

    @Override
    public List<Livre> getResultLivre(String chaine) throws NotFoundException {

        String simpleQuote="'";
        String genre = simpleQuote+chaine+simpleQuote;

        String vSQL = "SELECT * FROM livre WHERE genre ="+genre;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Livre> vRowMapper = new LivreRM();

        List<Livre> vList = vJdbcTemplate.query(vSQL, vRowMapper);
        return vList;
    }


}
