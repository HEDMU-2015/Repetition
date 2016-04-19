package repetition.opgava4;

import java.time.LocalDate;

/**
 * 
 * @author Juyoung Choi
 *
 */

public class Person {
	private final int id;
	private final String name;
	private final String email;
	private final LocalDate birthday;

//		public Person() {
//		}

	
	public Person(final int newId, final String newName, final String newEmail, final LocalDate newBirthday){
		this.id = newId;
		this.name = newName;
		this.email = newEmail;
		this.birthday = newBirthday;
	}

	public static class Builder{
		private int nestedId;
		private String nestedName;
		private String nestedEmail;
		private LocalDate nestedBirthday;

		public Builder(final String newName, final String newEmail, final LocalDate newBirthday){
		
			this.nestedName = newName;
			this.nestedEmail = newEmail;
			this.nestedBirthday = newBirthday;
		}

		public Builder id(int newId){
			this.nestedId = newId;
			return this;
		}

		public Builder name(String newName){
			this.nestedName = newName;
			return this;
		}

		public Builder email(String newEmail){
			this.nestedEmail = newEmail;
			return this;
		}

		public Builder birthday(LocalDate newBirthday){
			this.nestedBirthday = newBirthday;
			return this;
		}

		public Person createPerson(){
			return new Person(nestedId, nestedName, nestedEmail, nestedBirthday);
		}
	}

	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", birthday=" + birthday + "]";
	}


}
