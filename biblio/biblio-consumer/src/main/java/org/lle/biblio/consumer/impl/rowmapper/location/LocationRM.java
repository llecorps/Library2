package org.lle.biblio.consumer.impl.rowmapper.location;

import org.lle.biblio.model.bean.location.Location;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TheAdmin on 29.01.2019.
 */
@Named
public class LocationRM implements RowMapper<Location> {

    @Override
    public Location mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Location vLocation = new Location();
        vLocation.setId(pRS.getInt("id"));
        vLocation.setUtilisateur_id(pRS.getInt("utilisateur_id"));
        vLocation.setLivre_id(pRS.getInt("livre_id"));
        vLocation.setExpiredate(pRS.getString("expiredate"));
        vLocation.setProlongation(pRS.getBoolean("prolongation"));

        return vLocation;
    }
}
