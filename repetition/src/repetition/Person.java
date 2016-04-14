package repetition;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {

	private String name;
	private LocalDate birthday;
	private int age;

	public Person(String name, LocalDate birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		age = (int) ChronoUnit.YEARS.between(birthday, LocalDate.now());
		return age;
	}

	@Override
	public String toString() {
		return "[name: " + name + ", age: " + getAge() + ", birthday: " + birthday + "]";
	}

}