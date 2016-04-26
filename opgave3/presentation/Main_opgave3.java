package presentation;

import logic.EmploymentLogic_opgave3;

//import java.time.LocalDate;

//import domain.Person;
import logic.PersonLogic_opgave3;

//import java.time.LocalDate;

public class Main_opgave3 {

	public static void main(String[] args) {
		PersonLogic_opgave3 personLogic = new PersonLogic_opgave3();
//		Person person = new Person("Dean", "dean@me.com", LocalDate.of(1970,02,03));
//		personLogic.create(person);
		
		System.out.println(personLogic.read(5));
		
		EmploymentLogic_opgave3 employmentLogic = new EmploymentLogic_opgave3();
		System.out.println(employmentLogic.read(9)); // not with NoSuchElementException but just Optional.empty
		
		
	}

}
