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


	public static class Builder{
		private int nestedId = 0;
		private final String nestedName;
		private final String nestedEmail;
		private final LocalDate nestedBirthday;

		public Builder( String newName,  String newEmail,  LocalDate newBirthday){

			this.nestedName = newName;
			this.nestedEmail = newEmail;
			this.nestedBirthday = newBirthday;
		}

		public Builder id(int newId){
			this.nestedId = newId;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}
	}

	private Person (Builder builder){
		id = builder.nestedId;
		name = builder.nestedName;
		email = builder.nestedEmail;
		birthday = builder.nestedBirthday;
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
		return "Person [name=" + name + ", email=" + email + ", birthday=" + birthday + "]";
	}


}
