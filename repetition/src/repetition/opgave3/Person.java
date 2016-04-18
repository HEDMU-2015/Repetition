package repetition.opgave3;

import java.time.LocalDate;

/**
 * 
 * @author Juyoung Choi
 *
 */

public class Person {
	private int id;
	private String name;
	private String email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", birthday=" + birthday + "]";
	}
	
	
}
