package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Person extends Model {
	@Id
	public Long id;
	public String firstName;
	public String lastName;

	public static Finder<String, Person> find = new Finder<String, Person>(String.class, Person.class);

}