package repetition2;

import java.time.LocalDate;

public class Employment {

	int id;
	String company;
	LocalDate employmentdate;
	int person;

	public Employment(int id, String company, LocalDate employmentdate, int person) {
		this.id = id;
		this.company = company;
		this.employmentdate = employmentdate;
		this.person = person;
	}

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

	public LocalDate getEmploymentdate() {
		return employmentdate;
	}

	public void setEmploymentdate(LocalDate employmentdate) {
		this.employmentdate = employmentdate;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Employment [id=" + id + ", company=" + company + ", employmentdate=" + employmentdate + ", person="	+ person + "]";
	}
}
