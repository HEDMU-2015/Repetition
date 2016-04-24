
package repetition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
	List<Person> youngerThanNumber = new ArrayList<>();
	
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person("Marina ", "Marina@gmail.com", LocalDate.of(2000, 2, 16));
		Person p2 = new Person("Anders ", "Anders@gmail.com", LocalDate.of(1960, 7, 22));
		Person p3 = new Person("Knud ", "Knud@gmail.com", LocalDate.of(2010, 12, 10));
		Person p4 = new Person("Sara ", "Sara@gmail.com", LocalDate.of(1987, 4, 2));
		Person p5 = new Person("Susanne ", "Susanne@gmail.com", LocalDate.of(1978, 9, 3));
		Person p6 = new Person("Marianne ", "Marianne@gmail.com", LocalDate.of(1995, 3, 16));
		Person p7 = new Person("Andersine ", "Andersine@gmail.com", LocalDate.of(1967, 7, 22));
		Person p8 = new Person("Rene ", "Rene@gmail.com", LocalDate.of(2006, 12, 10));
		Person p9 = new Person("Mathias ", "Mathias@gmail.com", LocalDate.of(1989, 4, 2));
		Person p10 = new Person("Thomas ", "Thomas@gmail.com", LocalDate.of(1979, 9, 3));
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);
		persons.add(p6);
		persons.add(p7);
		persons.add(p8);
		persons.add(p9);
		persons.add(p10);

		// System.out.println(persons);
		Main m = new Main();
		m.elderThan25(persons);
//		m.printNames(persons);
		
		Util<Person, Person> u = new Util<>();
		Util<Person, String> u2 = new Util<>();
		
	
		System.out.println("Personer under 30 år "
				+ u.reduce(persons, (Person p) -> p, p -> p.getAgeAt(LocalDate.of(2020, 01, 01)) < 30));

		
		System.out.println("Personer mellem 10 og 20 "
				+ u2.reduce(persons,
						(Person p)-> p.getAgeAt(LocalDate.of(2010, 01, 01)) < 20 && p.getAgeAt(LocalDate.of(2010, 1, 1)) >10,
						p->p.getName()));
	}

	public List<Person> elderThan25(List<Person> persons) {
		List<Person> elderThan25 = new ArrayList<>();

		for (Person person : persons) {
			if (person.getAge() > 25) {
				elderThan25.add(person);
			}

		}
//		System.out.println(elderThan25);
		return elderThan25;
	}

	

	
	// Mellem 10 og 20

//	public void printNames(List<Person>persons){
//		List<String> per = new ArrayList<>();
//		
//		for (Person person : persons) {
//			if(person.getAgeAt(LocalDate.of(2020, 1, 1))<20 && person.getAgeAt(LocalDate.of(2020, 1, 1))>10){
//				per.add(person.getName());
//			}
//		}
//		System.out.println(per);
			
//		}
}
