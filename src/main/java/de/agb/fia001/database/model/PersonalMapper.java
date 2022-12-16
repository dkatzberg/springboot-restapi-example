package de.agb.fia001.database.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This class maps a result object from the jdbc connector to a java object.
 * 
 * @author Daniel Katzberg
 *
 */
public class PersonalMapper implements RowMapper<Personal>  {

	@Override
	public Personal mapRow(ResultSet rs, int rowNum) throws SQLException {
		//Sets all values from the personal object,
		Personal personal = new Personal();
		personal.setId(rs.getInt("id"));
		personal.setVorname(rs.getString("vorname"));
		personal.setNachname(rs.getString("nachname"));
		personal.setKlasse(rs.getString("klasse"));
		
		return personal;
	}
	

}
