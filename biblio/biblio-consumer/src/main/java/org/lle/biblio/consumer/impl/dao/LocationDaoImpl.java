package org.lle.biblio.consumer.impl.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lle.biblio.consumer.contract.dao.LocationDao;
import org.lle.biblio.consumer.impl.rowmapper.location.BookingRM;
import org.lle.biblio.consumer.impl.rowmapper.location.LocationRM;
import org.lle.biblio.model.bean.livre.Booking;
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

    @Inject
    private BookingRM bookingRM;


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
    public List<Booking> getListReservation(int id) {

        String vSQL = "SELECT * FROM booking WHERE user_id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Booking> vRowMapper = new BookingRM();

        List<Booking> vListReservation = vJdbcTemplate.query(vSQL, vRowMapper);
        return vListReservation;
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
    public List<Booking> listBooking() {

        String vSQL = "SELECT * FROM booking ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        RowMapper<Booking> vRowMapper = new BookingRM();

        List<Booking> vListBooking = vJdbcTemplate.query(vSQL, vRowMapper);
        return vListBooking;
    }

    @Override
    public int getNbreLocation(int pId) {

        String vSQL = "SELECT COUNT(*) FROM booking WHERE livre_id ="+pId;

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("livre_id", pId);

            int vNbreLocation = vJdbcTemplate.queryForObject(vSQL, vParams, Integer.class);
            return vNbreLocation;
    }

    @Override
    public int getPosition(int pId) throws NotFoundException {

        String vSQL = "select position from booking where livre_id="+pId+"order by position desc limit 1;";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("livre_id", pId);

        try {

            int vPosition = vJdbcTemplate.queryForObject(vSQL, vParams, Integer.class);
            return vPosition;
        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Emprunt non trouvé utilisateur_id=" + pId);

        }
    }

    @Override
    public String getExpiredate(int pId)  {

        String vSQL = "select expiredate from location where livre_id="+pId+"order by expiredate desc limit 1;";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("livre_id", pId);

            String vExpiredate = vJdbcTemplate.queryForObject(vSQL, vParams, String.class);
            return vExpiredate;

    }

    @Override
    public void delLoc(Location location){

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(location);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());


        String vSQL = "delete FROM public.location where utilisateur_id="+location.getUtilisateur_id()+"and livre_id="+location.getLivre_id()+";COMMIT; ";

        try {
            vJdbcTemplate.update(vSQL, vParams);

        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Location delete impossible ! id=" + location.getUtilisateur_id(), vEx);
            // ...
        }


    }

    @Override
    public Booking userPosition(int pId) throws NotFoundException {

        String vSQL = "select * from booking where livre_id=" + pId + " order by position asc limit 1;";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("livre_id", pId);
        Booking booking = null;
        try {
            booking = vJdbcTemplate.queryForObject(vSQL, vParams, bookingRM);
            return booking;
        } catch (IncorrectResultSizeDataAccessException vEx) {
            throw new NotFoundException("Booking not found!=" + booking);


        }


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

    @Override
    public void addNotif(String date, int pId) {

        String simpleQuote = "'";
        String expireDate = simpleQuote + date + simpleQuote;
        String dispo = "disponible";

        String vSQL = "update booking set notification="+expireDate+", bookingdate='disponible'  WHERE id="+pId+";COMMIT;";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("notification", date, Types.VARCHAR);
        vParams.addValue("bookingdate", dispo, Types.VARCHAR);
        vParams.addValue("id", pId, Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParams);


    }

    @Override
    public void addBooked (Booking pBooking) {

        String simpleQuote="'";
        String expireDate = simpleQuote+pBooking.getBookingdate()+simpleQuote;

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pBooking);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());


        String vSQL = "INSERT INTO booking (user_id, livre_id, bookingdate, position) VALUES ("
                +pBooking.getUser_id()+","+pBooking.getLivre_id()+","+expireDate+","+pBooking.getPosition()+");COMMIT; ";

        try {
            vJdbcTemplate.update(vSQL, vParams);

        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Booking impossible ! id=" + pBooking.getId(), vEx);
            // ...
        }

    }

    @Override
    public void delBooked(int id) {

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(id);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());


        String vSQL = "delete FROM public.booking where id="+id+";COMMIT; ";

        try {
            vJdbcTemplate.update(vSQL, vParams);

        } catch (DuplicateKeyException vEx) {
            LOGGER.error("Annulation impossible ! id=" + id, vEx);
            // ...
        }

    }

}
