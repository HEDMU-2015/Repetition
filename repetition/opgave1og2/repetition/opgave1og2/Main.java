package repetition.opgave1og2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Juyoung Choi
 *
 */
public class Main {
	public static void main(String[] args) {

		List<Person> persons = new Main().lavList();
		System.out.println("List : " + persons);

		System.out.println("\n***********************************************\n");


		Util<Person, Person> util = new Util<>();
		System.out.println("UTIL 25 år : " 
				+ util.reduce(persons,
						(Person p) -> p.getAge()> 25,  
						p -> p)); 


		System.out.println("UTIL 25 år med anden metode : " 
				+ util.reduce(persons,						
						(Person p) -> p, 
						p -> p.getAge()> 25  
						));

		System.out.println("\n***********************************************\n");

		Util<Person, String> util1 = new Util<>();
		System.out.println("UTIL 10-20 år : " 				
				+ util1.reduce(persons,
						(Person p) -> p.getAgeAt(LocalDate.of(2020, 01, 01))<=20 && p.getAgeAt(LocalDate.of(2020, 01, 01))>=10,
						p -> p.getName()));

		System.out.println("UTIL 30 år : " 
				+ util.reduce(persons, 
						(Person p) -> p,
						p-> p.getAgeAt(LocalDate.of(2010, 01, 01)) < 30));
	}


	private List<Person> lavList(){

		List <Person> personList = new ArrayList<>();
		personList.add(new Person("Juyoung", "juy@me.com", LocalDate.of(1982,01,17)));
		personList.add(new Person("Jesper", "jesp@me.com", LocalDate.of(1974,07,18)));
		personList.add(new Person("Mina", "mina@me.com", LocalDate.of(2010,02,17)));
		personList.add(new Person("Kim", "kim@me.com", LocalDate.of(2000,12,17)));
		personList.add(new Person("Park", "park@me.com", LocalDate.of(1990,02,22)));

		return personList;
	}

}
