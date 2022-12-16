/**
 * 
 */
package de.agb.fia001.database.model;

/**
 * OORM class for the table "personal" in the mysql database.
 * 
 * @author DanielKatzberg
 *
 */
public class Personal {

	private Integer id;

	private String vorname;

	private String nachname;

	private String klasse;

	/**
	 * Default Constructor sets default values.
	 */
	public Personal() {
		this(0,"","","");
	}

	/**
	 * This constructor sets all values for a personal object.
	 * 
	 * @param id - Primary Key
	 * @param vorname - first name
	 * @param nachname - last name
	 * @param klasse - class 
	 */
	public Personal(Integer id, String vorname, String nachname, String klasse) {
		this.setId(id);
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setKlasse(klasse);
	}

	/* GETTER / SETTER */ 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", klasse=" + klasse + "]";
	}
}
