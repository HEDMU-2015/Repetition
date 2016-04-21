package domain;

import java.time.LocalDate;

public class PersonBuilder {

	private final int id;
	private final String name;
	private final LocalDate birthday;

	public static class Builder {

		private final int builderId;
		private final String builderName;
		private final LocalDate builderBirthday;

		public Builder(int newId, String newName, LocalDate newBirthday) {
			this.builderId = newId;
			this.builderName = newName;
			this.builderBirthday = newBirthday;
		}

		public PersonBuilder build() {
			return new PersonBuilder(this);
		}

	}

	private PersonBuilder(Builder builder) {
		id = builder.builderId;
		name = builder.builderName;
		birthday = builder.builderBirthday;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	@Override
	public String toString() {
		return "[name: " + name + ", email: " + ", birthday: " + birthday + "]";
	}

}