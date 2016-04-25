package repetition;

import java.util.Date;

public class Employment {
	int id;
	String company;
	Date employmentdate;

	public Employment(int id,String company, Date employmentdate){
		this.id=id;
		this.company=company;
		this.employmentdate=employmentdate;
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

	public Date getEmploymentdate() {
		return employmentdate;
	}

	public void setEmploymentdate(Date employmentdate) {
		this.employmentdate = employmentdate;
	}
	
	
}
