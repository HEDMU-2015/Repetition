package repetition.opgava4;

import java.time.LocalDate;

/**
 * 
 * @author Juyoung Choi
 *
 */


public class Employment {
	private int id;
	private String company;
	private LocalDate employment;
	private Person person;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public LocalDate getEmployment() {
		return employment;
	}
	public void setEmployment(LocalDate employment) {
		this.employment = employment;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "Employment [id=" + id + ", company=" + company + ", employment=" + employment + ", person=" + person
				+ "]";
	}

}
