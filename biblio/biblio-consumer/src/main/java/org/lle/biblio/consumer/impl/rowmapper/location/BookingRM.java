package org.lle.biblio.consumer.impl.rowmapper.location;

import org.lle.biblio.model.bean.livre.Booking;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by TheAdmin on 29.01.2019.
 */
@Named
public class BookingRM implements RowMapper<Booking> {

    @Override
    public Booking mapRow(ResultSet pRS, int pRowNum) throws SQLException {

        Booking vBooking = new Booking();
        vBooking.setId(pRS.getInt("id"));
        vBooking.setUser_id(pRS.getInt("user_id"));
        vBooking.setLivre_id(pRS.getInt("livre_id"));
        vBooking.setBookingdate(pRS.getString("bookingdate"));
        vBooking.setPosition(pRS.getInt("position"));
        vBooking.setNotification(pRS.getString("notification"));

        return vBooking;
    }
}
