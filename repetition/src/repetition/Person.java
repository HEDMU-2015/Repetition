package repetition;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	private String name;
	private String email;
	private LocalDate birthdate;
	private LocalDate today;
	private Period difference;

	public Person() {
	}

	public Person(String name, String email, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
	}

	// LocalDate birthdate = new LocalDate (1970, 1, 20);
	// LocalDate now = new LocalDate();
	// Years age = Years.yearsBetween(birthdate, now);

	public int getAge() {
		today = LocalDate.now();
		difference = Period.between(birthdate, today);

		return difference.getYears();
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
		String toString = ">>Name: " + name + ", Email: " + email  + ", Birthdate: "+birthdate+ ", Age: " + getAge()+"<<";
		return toString;
	}

}
