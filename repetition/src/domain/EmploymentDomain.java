package domain;

import java.time.LocalDate;

public class EmploymentDomain {
	private long id;
	private String company;
	private LocalDate employmentdate;
	private long person;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public LocalDate getEmploymentdate() {
		return employmentdate;
	}
	public void setEmploymentdate(LocalDate employmentdate) {
		this.employmentdate = employmentdate;
	}
	public long getPerson() {
		return person;
	}
	public void setPerson(long person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "EmploymentDomain [id=" + id + ", company=" + company + ", employmentdate=" + employmentdate
				+ ", person=" + person + "]";
	}
	
	
}
