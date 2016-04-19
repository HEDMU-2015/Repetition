package repetition;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	private String name;
	private String email;
	private LocalDate birthdate;

	public Person() {
	}

	public Person(String name, String email, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public int getAge() {
		LocalDate currentDate = LocalDate.now();
		Period ageInPeriod = Period.between(birthdate, currentDate);
		int ageInInt = ageInPeriod.getYears();

		return ageInInt;

	}

	public String toString() {
		return "Navn: " + name + " \t Email: - " + email + " \t birthdate: - " + birthdate;

	}

}
