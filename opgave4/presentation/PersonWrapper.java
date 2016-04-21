package presentation;

import java.time.LocalDate;

import domain.Person;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonWrapper {
	private final StringProperty name;
	private final StringProperty email;
	private final StringProperty birthday;
	
	private Person person;
	
	public PersonWrapper(){
		this( null, null, null);
	}
	
	public PersonWrapper(String name, String email, LocalDate birthday){
		this.name = new SimpleStringProperty(person.getName());
		this.email = new SimpleStringProperty(person.getEmail());
		this.birthday = new SimpleStringProperty (person.getBirthday().toString());
	}

	
	public StringProperty getName() {
		return name;
	}

	public StringProperty getEmail() {
		return email;
	}

	public StringProperty getBirthday() {
		return birthday;
	}
	
	
	
}
