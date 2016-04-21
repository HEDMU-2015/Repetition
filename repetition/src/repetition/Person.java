package repetition;

import java.time.LocalDate;

public class Person {
	private String name;
	private String email;
	private LocalDate birthdate;

	

	public Person(String name, String email, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
	}
	
	public long getAge() {
		LocalDate Today = LocalDate.now();
		LocalDate tempDate = LocalDate.from(birthdate);
		
		return Util.differenceInYears(Today, tempDate);
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
		return "Person [name=" + name + ", email=" + email + ", birthdate=" + birthdate + ", getAge()=" + getAge()
				+ "]";
	}
	
}
