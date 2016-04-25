package domain;

import java.time.LocalDate;

import repetition.Util;

public class PersonDomain {
	private long id;
	private String name;
	private String email;
	private LocalDate birthdate;
	
	public int getAge() {
		return getAgeAt(LocalDate.now());
	}
	
	public int getAgeAt(LocalDate date) {
		return Util.differenceInYears(birthdate, date);
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		return "PersonDomain [id=" + id + ", name=" + name + ", email=" + email + ", birthdate=" + birthdate + "]";
	}
	
	
}
