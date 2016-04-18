package domain;

import java.time.LocalDate;

public class Employment {

	private int id;
	private int personId;
	private String company;
	private LocalDate employmentDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public LocalDate getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(LocalDate employmentDate) {
		this.employmentDate = employmentDate;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", personId: " + personId + ", company: " + company + ", employmentDate: "
				+ employmentDate + "]";
	}
}
