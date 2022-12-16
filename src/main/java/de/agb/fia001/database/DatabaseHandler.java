package de.agb.fia001.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import de.agb.fia001.database.model.Personal;
import de.agb.fia001.database.model.PersonalMapper;

/**
 * This repository class
 * 
 * @author Daniel Katzberg
 *
 */
@Repository("databaseHandler")
public class DatabaseHandler {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * This method returns a list of all personal object, which are in the database.
	 * 
	 * @return A list of all personal entries of the database
	 */
	public List<Personal> selectAllPersonal() {
		String sqlQuery = "SELECT * FROM Personal";
		List<Personal> personalList = jdbcTemplate.query(sqlQuery, new PersonalMapper());
		personalList.forEach(p -> System.out.println(p.toString()));// just debugging

		return personalList;
	}

	public void savePersonal(Personal personal) {

		String sqlQuery = "INSERT INTO Personal (vorname, nachname, klasse) VALUES (?,?,?)";
		this.jdbcTemplate.update(sqlQuery, personal.getVorname(), personal.getNachname(), personal.getKlasse());
	}

	public void updatePersonal(Personal personal) {

		String sqlQuery = "UPDATE Personal SET vorname = ?, nachname = ?, klasse = ? WHERE id = ?";
		this.jdbcTemplate.update(sqlQuery, personal.getVorname(), personal.getNachname(), personal.getKlasse(),
				personal.getId());
	}

}
