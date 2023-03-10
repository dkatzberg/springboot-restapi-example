package de.agb.fia.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import de.agb.fia.database.model.Personal;
import de.agb.fia.database.model.PersonalMapper;

/**
 * This database handler uses the jdbc template to push sql statements to the
 * database.
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

	/**
	 * This method add a single personal object to the database.
	 * 
	 * @param Personal object which will be added to the personal table in the
	 *                 database.
	 */
	public void savePersonal(Personal personal) {

		String sqlQuery = "INSERT INTO Personal (vorname, nachname, klasse) VALUES (?,?,?)";
		this.jdbcTemplate.update(sqlQuery, personal.getVorname(), personal.getNachname(), personal.getKlasse());
	}

	/**
	 * This method updates a single person object in the database.
	 * 
	 * @param personal Object, which will be updated in the database.
	 */
	public void updatePersonal(Personal personal) {

		String sqlQuery = "UPDATE Personal SET vorname = ?, nachname = ?, klasse = ? WHERE id = ?";
		this.jdbcTemplate.update(sqlQuery, personal.getVorname(), personal.getNachname(), personal.getKlasse(),
				personal.getId());
	}

	protected JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	protected void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
