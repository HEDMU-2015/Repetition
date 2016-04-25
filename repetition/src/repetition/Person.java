package repetition;

import java.time.LocalDate;

public class Person {
	private final String name;
	private final String email;
	private final LocalDate birthdate;
	
	public static class Builder {
		private String name;
		private String email;
		private LocalDate birthdate;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		public Builder setBirthdate(LocalDate birthdate) {
			this.birthdate = birthdate;
			return this;
		}
		public Person build() {
			return new Person(this);
		}
		
	}
	
	private Person(Builder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.birthdate = builder.birthdate;
	}
	
	public int getAge() {
		return Util.differenceInYears(birthdate, LocalDate.now());
	}
	
	public int getAgeAt(LocalDate date) {
		return Util.differenceInYears(birthdate, date);
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", birthdate=" + birthdate + "]";
	}
	
}
