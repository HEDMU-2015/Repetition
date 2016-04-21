package newPerson;
import java.time.LocalDate;
import java.time.Period;

public class Person {
	private String name;
	private String email;
	private LocalDate birthdate;
	private int age;

	public Person() {
	}

	public Person(String name, String email, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
	}

	public int getAge() {
		age = Util.differenceInYears(birthdate, LocalDate.now());
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeAt(LocalDate date) {
		return Period.between(birthdate, date).getYears();
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
		return "Navn: " + name + " Email: " + email + " Fødselsdagsdato: " + birthdate + " Alder: " + age;
	}

}
