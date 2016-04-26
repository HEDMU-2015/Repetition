package repetition;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	private String name;
	private String email;
	private LocalDate birthdate;
	private LocalDate today;
	private Period difference;
	private int ID;
	

	public Person() {
	}

	public Person(String name, String email, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
	}

	public int getAge() {

		today = LocalDate.now();
		// difference = Period.between(birthdate, today);
		
		return Util.differenceInYears(birthdate, today);
	}
	
	public int getAgeAt(LocalDate date) {

		return Util.differenceInYears(birthdate, date);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		String toString = ">>Name: " + name + ", Email: " + email + ", Birthdate: " + birthdate + ", Age Today: " + getAge()
				+ "<<";
		return toString;
	}
	
	public LocalDate getBirthdate(){
		return birthdate;
	}
	
	public void setBirthdate(LocalDate birthdate){
		this.birthdate = birthdate;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setID(int ID){
		this.ID=ID;
	}
	
	

}
