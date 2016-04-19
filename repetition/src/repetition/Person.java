package repetition;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
	private String name;
	private String email;
	private long age;
	private LocalDate birthdate;
	
	public Person() {
	}
	
	public Person(String name, String email, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
	}
	
	public long getAge() {
		 long age = ChronoUnit.YEARS.between(birthdate, LocalDate.now()); 
		 	//http://www.leveluplunch.com/java/examples/number-of-years-between-two-dates/
		return age;
	}
	
	public void setAge(long age) {
		this.age = age;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
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

	@Override
	public String toString() {
		return "[name= " + name + ", email= " + email + ", age= " + age + ", birthdate= " + birthdate + "]";
	}
	
}
