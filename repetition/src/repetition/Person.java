package repetition;

import java.time.LocalDate;

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
	
	public int getAge() {
		// ?
		return 0;
	}
	
}
