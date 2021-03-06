package repetition;

import java.time.LocalDate;
import java.time.Period;

public class Person2 {
	private String name;
	private String email;
	private LocalDate birthdate;

	public int getAge() {
		return Period.between(birthdate, LocalDate.now()).getYears();
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

	@Override
	public String toString() {
		return "Person2 [name=" + name + ", email=" + email + ", birthdate=" + birthdate + "]";
	}
	
	
}
