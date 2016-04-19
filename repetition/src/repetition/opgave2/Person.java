package repetition.opgave2;

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
	
	public int getAge() {
		int age = Util.differenceInYears(birthdate, LocalDate.now());
		return age;
	}

	public int getAgeAt(LocalDate date) {
		int ageAt = Util.differenceInYears(birthdate, date);
		return ageAt;
	}
	@Override
	public String toString() {
		return "Person [navn=" + name + ", email=" + email + ", fødselsdato=" + birthdate + ", alder=" + getAge()
				+ "]";
	}

	
			
	}
	

