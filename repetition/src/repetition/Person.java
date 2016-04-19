package repetition;
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
		LocalDate today = LocalDate.now();
		LocalDate birthday = birthdate;
		
	//	Period p = Period.between(birthday, today);
		int alder = (int) ChronoUnit.YEARS.between(birthday, today);
		
	//	LocalDate birthdate = birthday.withYear(today.getYear());
		System.out.println(alder + "her i getAge");
		
		return alder;
	
	}
	
}
