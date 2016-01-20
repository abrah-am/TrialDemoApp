package controllers;

import play.*;
import play.mvc.*;
import play.db.ebean.Model;

import play.data.Form;
import models.Person;
import java.util.List;
import java.util.ArrayList;

import views.html.*;

public class Application extends Controller {

    public Result index() {
    	List<Person> people = Person.find.all();
        return ok(index.render("Trial Demo Application", people));
    }

    public Result addPerson() {
    	Person person = Form.form(Person.class).bindFromRequest().get();
    	person.save();
    	return redirect(routes.Application.index());
    }

    public Result searchPersonByName() {
    	String name = Form.form().bindFromRequest().get("name");
    	List<Person> people = Person
    		.find
    		.where()
    		.ilike("firstName", "%"+name+"%")
    		.findList();	
    	return ok(index.render("Trial Demo Application", people));
    }
}
