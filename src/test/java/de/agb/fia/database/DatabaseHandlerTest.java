package de.agb.fia.database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import de.agb.fia.database.model.Personal;

public class DatabaseHandlerTest {
	
	private DatabaseHandler databaseHandler;

	@BeforeEach
	public void createDatabaseHandler() {
		DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:jdbc/schema.sql")
				.addScript("classpath:jdbc/testdata.sql")
				.build();
		this.databaseHandler = new DatabaseHandler();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		databaseHandler.setJdbcTemplate(jdbcTemplate);
	}
	
	@AfterEach
	public void destroyDatabaseHandler() {
		this.databaseHandler = null;
	}

	@Test
	public void testInMemoryDatabaseAndSelectAllPersonal() {
		// Arrange

		// Act
		List<Personal> allPersonal = this.databaseHandler.selectAllPersonal();

		// Assert
		assertEquals(2, allPersonal.size());
		assertEquals("Max", allPersonal.get(0).getVorname());
		assertEquals("Mustermann", allPersonal.get(0).getNachname());
		assertEquals("FIA", allPersonal.get(0).getKlasse());
		assertEquals(3, allPersonal.get(1).getId());
		assertEquals("Klaus", allPersonal.get(1).getVorname());

	}

}
