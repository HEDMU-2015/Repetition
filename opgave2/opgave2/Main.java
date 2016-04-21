package opgave2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Person> persons;
	private static Util<Person, String> util = new Util<>();
	private static Util<Person, Person> util2 = new Util<>();

	public static void main(String[] args) {
		persons = new ArrayList<>();
		for (Person person : createlistOfPersons()) {
			persons.add(person);
		}

		printListOfPersons();
		printListOfPersonsOlderThan25();
		printListOfPersonsBetween10And20WithReduce1();
		printListOfPersonsBetween10And20WithReduce2();
		printListOfPersonsUnder30WithReduce1();
		printListOfPersonsUnder30WithReduce2();
	}

	public static List<Person> createlistOfPersons() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Dennis", LocalDate.of(1999, 9, 23)));
		persons.add(new Person("Katharina", LocalDate.of(1995, 10, 10)));
		persons.add(new Person("Bent", LocalDate.of(1983, 1, 17)));
		persons.add(new Person("Kurt", LocalDate.of(1970, 3, 14)));
		persons.add(new Person("Birthe", LocalDate.of(1975, 12, 7)));
		persons.add(new Person("Hans", LocalDate.of(2000, 2, 9)));
		persons.add(new Person("Anders", LocalDate.of(2001, 1, 2)));
		persons.add(new Person("Pernille", LocalDate.of(1990, 11, 27)));
		persons.add(new Person("Verner", LocalDate.of(1966, 5, 12)));
		persons.add(new Person("Lisette", LocalDate.of(1987, 6, 15)));
		return persons;
	}

	public static void printListOfPersons() {
		System.out.println("List of persons");
		System.out.println(persons);
		System.out.println("");
	}

	public static void printListOfPersonsOlderThan25() {
		System.out.println("Lists of persons elder than 25");
		System.out.println(new PersonUtil().getNamesOver25(persons));
		System.out.println("");
	}

	public static void printListOfPersonsUnder30WithReduce1() {
		System.out.println("List of persons who's younger than 30 (with reduce1)");
		System.out.println(util.reduce1(persons, p -> p.getAge() < 30, p -> p.getName()));
		System.out.println("");
	}

	public static void printListOfPersonsUnder30WithReduce2() {
		System.out.println("List of persons between 10 and 20 years old (with reduce2)");
		System.out.println(util2.reduce2(persons, p -> new Person(p.getName(), p.getBirthday()),
				p -> p.getAgeAt(LocalDate.of(2016, 04, 01)) > 30));
		System.out.println("");
	}

	public static void printListOfPersonsBetween10And20WithReduce1() {
		System.out.println("List of names who's between 10 and 20 years old (with reduce1)");
		System.out.println(util.reduce1(persons,
				(Person p) -> p.getAgeAt(LocalDate.of(2016, 4, 18)) < 20 && p.getAgeAt(LocalDate.of(2016, 4, 18)) > 10,
				p -> p.getName()));
		System.out.println("");
	}

	public static void printListOfPersonsBetween10And20WithReduce2() {
		System.out.println("List of persons who's younger than 30 (with reduce2)");
		System.out.println(util2.reduce2(persons, p -> new Person(p.getName(), p.getBirthday()),
				(Person p) -> p.getAgeAt(LocalDate.of(2016, 4, 18)) < 20
						&& p.getAgeAt(LocalDate.of(2016, 4, 18)) > 10));
		System.out.println("");
	}

}