package de.agb.fia.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Configuration class for the MySQL Connection
 * 
 * @author Daniel Katzberg
 *
 */
@Configuration
public class MySqlConfiguration {
	
	/**
	 * The Data Source Object for the configuration and connection to the MySQL
	 * Database.
	 * @return The generated Datasource Object.
	 */
	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("<database_uri>");
		dataSource.setUsername("<database_user>");
		dataSource.setPassword("<database_password>");

		return dataSource;
	}

	/**
	 * This method generated the Jdbc Template, based on the Datasource object.
	 * @return The generated Jdbc Template.
	 */
	@Bean
	public JdbcTemplate getJdbcTemplate() {
	  return new JdbcTemplate(this.mysqlDataSource());
	}

}
