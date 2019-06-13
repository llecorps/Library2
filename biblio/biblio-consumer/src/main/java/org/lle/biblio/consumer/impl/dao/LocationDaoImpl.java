package org.lle.biblio.consumer.impl.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lle.biblio.consumer.contract.dao.LocationDao;
import org.lle.biblio.consumer.impl.rowmapper.location.LocationRM;
import org.lle.biblio.model.bean.location.Location;
import org.lle.biblio.model.exception.NotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Created by TheAdmin on 29.01.2019.
 */
@Named
public class LocationDaoImpl extends AbstractDaoImpl implements LocationDao {

    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(LocationDaoImpl.class);



    @Inject
    private LocationRM locationRM;


    @Override
    public Location getLocation(int pId) throws NotFoundException {
        String vSQL = "SELECT * FROM location WHERE utilisateur_id ="+pId;
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("utilisateur_id", pId);
        try {
            Location vLocation = vJdbcTemplate.queryForObject(vSQL, vParams, locationRM);
            return vLocation;
        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Emprunt non trouvé utilisateur_id=" + pId);
        }
    }

    @Override
    public Location getLivrelocation(int pId) throws NotFoundException {
        String vSQL = "SELECT * FROM location WHERE livre_id ="+pId;
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("livre_id", pId);
        try {
            Location vLocation = vJdbcTemplate.queryForObject(vSQL, vParams, locationRM);
            return vLocation;
        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Emprunt non trouvé livre_id=" + pId);
        }
    }

    @Override
    public int getExemplaire(int pId) throws NotFoundException {

        String vSQL = "SELECT COUNT(*) FROM location WHERE livre_id ="+pId;

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("livre_id", pId);
        try {
            int vExemplaire = vJdbcTemplate.queryForObject(vSQL, vParams, Integer.class);
            return vExemplaire;
        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Emprunt non trouvé utilisateur_id=" + pId);

        }

    }

    @Override
    public void addEmprunt(Location pLoc) {

        String simpleQuote="'";
        String expireDate = simpleQuote+pLoc.getExpiredate()+simpleQuote;

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pLoc);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());


        String vSQL = "INSERT INTO location (utilisateur_id, livre_id, expiredate, prolongation) VALUES ("
        +pLoc.getUtilisateur_id()+","+pLoc.getLivre_id()+","+expireDate+","+pLoc.isProlongation()+");COMMIT; ";

        try {
            vJdbcTemplate.update(vSQL, vParams);

        } catch (DuplicateKeyException vEx) {
            LOGGER.error("L'Emprunt existe déjà ! id=" + pLoc.getId(), vEx);
            // ...
        }
        
    }

    @Override
    public List<Location> getListLocation(int id) {

        String vSQL = "SELECT * FROM location WHERE utilisateur_id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Location> vRowMapper = new LocationRM();

        List<Location> vListLocation = vJdbcTemplate.query(vSQL, vRowMapper);
        return vListLocation;
    }

    @Override
    public List<Location> listLocation() {

        String vSQL = "SELECT * FROM location ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Location> vRowMapper = new LocationRM();

        List<Location> vListLocation = vJdbcTemplate.query(vSQL, vRowMapper);
        return vListLocation;
    }

    @Override
    public void addProlo(String expiration, int pId) {

        String simpleQuote = "'";
        String expireDate = simpleQuote + expiration + simpleQuote;

        String vSQL = "update location set expiredate="+expireDate+", prolongation=FALSE WHERE id="+pId+";COMMIT;";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("expiredate", expireDate, Types.VARCHAR);
        vParams.addValue("id", pId, Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParams);


    }

}
