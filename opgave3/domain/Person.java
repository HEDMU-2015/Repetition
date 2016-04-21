package domain;

import java.time.LocalDate;

public class Person {

	private int id;
	private String name;
	private LocalDate birthday;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", name: " + name + ", birthday: " + birthday + "]";
	}

}
