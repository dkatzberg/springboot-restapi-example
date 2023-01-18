package de.agb.fia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Starting point for the application.
 * 
 * @author Daniel Katzberg
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"de.agb.fia"})
public class FiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiaApplication.class, args);
	}
}
