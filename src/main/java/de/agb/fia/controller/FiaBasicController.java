package de.agb.fia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.agb.fia.database.DatabaseHandler;
import de.agb.fia.database.model.Personal;

/**
 * The basic rest controller, which works as a demo version of an
 * RestController.
 * 
 * @author Daniel Katzberg
 *
 */
@RestController
public class FiaBasicController {

	@Autowired
	private DatabaseHandler databaseHandler;

	/**
	 * 
	 * @return A String as a "hi".
	 */
	@GetMapping("/halloFia")
	public String getGreeting() {
		return "Hi FIA";
	}

	/**
	 * 
	 * @return A String as a "bye".
	 */
	@GetMapping("/bye")
	public String getBisbald() {
		return "Bye.";
	}

	/**
	 * 
	 * @return All selected personal data.
	 */
	@GetMapping("/personal")
	public List<Personal> getPersonal() {
		return this.databaseHandler.selectAllPersonal();
	}

	// Curl Befehl:
	// curl -X POST localhost:8080/personal/save -H 'Content-type:application/json'
	// -d '{"vorname": "Niko", "nachname": "Mustermann", "klasse": "fia001"}'
	@PostMapping("/personal/save")
	public void newEmployee(@RequestBody Personal neuesPersonal) {
		this.databaseHandler.savePersonal(neuesPersonal);
	}

	// Curl Befehl:
	// curl -X PUT localhost:8080/personal/update -H 'Content-type:application/json'
	// -d '{"id": "4", "vorname": "Niko", "nachname": "Musterfrau", "klasse":
	// "fia001"}'
	@PutMapping("/personal/update")
	public void updateEmployee(@RequestBody Personal neuesPersonal) {
		this.databaseHandler.updatePersonal(neuesPersonal);
	}

}
