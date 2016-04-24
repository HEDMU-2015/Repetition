package domain;

import java.time.LocalDate;

public class Employment {
	
	int id; 
	LocalDate employmentdate; 
	Person person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getEmploymentdate() {
		return employmentdate;
	}
	public void setEmploymentdate(LocalDate employmentdate) {
		this.employmentdate = employmentdate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	} 
	
	
	
	
	
	
}




