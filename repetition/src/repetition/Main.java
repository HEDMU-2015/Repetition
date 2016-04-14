package repetition;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
	/**
	 * @author Martin Zylauv Kristensen
	 */
	public static void main(String[] args) {
		Person p;
		List<Person> personer = new ArrayList<Person>();
		Main m = new Main(); /*
								 * meget dumt lavet at lave denne instans af sig
								 * selv, overhovedet ikke optimalt, men uden
								 * denne instans af sig selv kommer der en fejl
								 */

		personer.add(p = new Person("Martin", "Martin@email.dk", LocalDate.of(1995, 07, 17)));
		personer.add(p = new Person("Ole", "Ole@email.dk", LocalDate.of(1960, 05, 13)));
		personer.add(p = new Person("Jens", "Jens@email.dk", LocalDate.of(1985, 12, 31)));
		personer.add(p = new Person("Kim", "Kim@email.dk", LocalDate.of(2010, 12, 24)));
		personer.add(p = new Person("Birgit", "email@email.dk", LocalDate.of(1974, 01, 01)));

		System.out.println("All persons:");
		for (Person pe : personer) {
			System.out.println(pe.toString());
		}
		System.out.println();
		System.out.println("Persons older than 25:");
		for (Person pe : m.elderThan25(personer)) {
			System.out.println(pe.toString());
		}

	}

	public List<Person> elderThan25(List<Person> personer) {
		List<Person> elderThan25list = new ArrayList<Person>();
		for (Person p : personer) {
			if (p.getAge() > 25) {
				elderThan25list.add(p);
			}
		}
		return elderThan25list;
	}

}