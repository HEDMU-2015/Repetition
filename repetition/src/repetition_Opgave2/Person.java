package repetition_Opgave2;
/* Ret Person-klassen:
 - getAge() skal benytte den nye Util-metode
 - Lav en metode getAgeAt(Localdate date), som returnerer personens alder en bestemt dato*/


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
	
	public int getAgeAt(LocalDate date){
		date.of(2016, 4, 19);
		
		return Period.between(birthdate, date);
	}
	
}
