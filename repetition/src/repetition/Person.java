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
		LocalDate today = LocalDate.now();
		int age = today.compareTo(birthdate);
		return age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", birthdate=" + birthdate + ", getAge()=" + getAge()
				+ "]";
	}

	
			
	}
	

