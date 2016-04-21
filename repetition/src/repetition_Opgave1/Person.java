package repetition_Opgave1;
/* Færdiggør Person-klassen
 - getters og setters
 - metoden getAge() (Hint: Brug klassen java.time.Period)
 - toString*/
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Person {
	private String name;
	private String email;
	private LocalDate birthdate;
	
	public Person() {
		getAge();
	}
	
	public Person(String name, String email, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
	}
		
	
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
		return "Person [name=" + name + ", email=" + email + ", birthdate=" + birthdate + "]";
	}
	
	
	
}
