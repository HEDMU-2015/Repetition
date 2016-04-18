package repetition;

import java.time.LocalDate;

/**
 * 
 * @author Juyoung Choi
 *
 */

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
	
	public int getAge(){
		return Util.differentInYears(birthdate, LocalDate.now());
//		return Period.between(birthdate, LocalDate.now()).getYears();		
	}
	
	public int getAgeAt(LocalDate date){
		
		return Util.differentInYears(birthdate, date);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", birthdate=" + birthdate + "]";
	}
	
	
	
}
