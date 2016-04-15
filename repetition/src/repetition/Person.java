package repetition;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
	
	public long getAge() {
		LocalDate Today = LocalDate.now();
		LocalDate tempDate = LocalDate.from(birthdate);
		long years = tempDate.until(Today, ChronoUnit.YEARS);
		tempDate = tempDate.plusYears(years);
		return years;
	}
	
}
