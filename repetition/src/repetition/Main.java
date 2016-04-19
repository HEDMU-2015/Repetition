package repetition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Main main = new Main();

		ArrayList<Person> people = new ArrayList<Person>();

		people.add(new Person("Sanne", "sanne@hej.dk", LocalDate.of(1983, 10, 17)));
		people.add(new Person("Heine", "heine@hej.dk", LocalDate.of(1983, 8, 29)));
		people.add(new Person("Lena", "lena@hej.dk", LocalDate.of(1960, 5, 28)));
		people.add(new Person("John", "john@hej.dk", LocalDate.of(1962, 3, 03)));
		people.add(new Person("Katrine", "kat@hej.dk", LocalDate.of(1988, 6, 6)));
		people.add(new Person("Brian", "brian@hej.dk", LocalDate.of(1987, 05, 19)));
		people.add(new Person("Buster", "bust@hej.dk", LocalDate.of(2008, 10, 05)));
		people.add(new Person("Nova", "nova@hej.dk", LocalDate.of(2009, 8, 8)));
		people.add(new Person("Waldemar", "walde@hej.dk", LocalDate.of(2007, 8, 12)));
		people.add(new Person("Flemming", "flem@hej.dk", LocalDate.of(1960, 5, 5)));
		System.out.println("Alle personer i listen:\n");
		for (Person name1 : people) {
			System.out.println(name1);

		}
		System.out.println("\n");
		System.out.println("Personer over 25 \n");
		List<Person> peopleOver25 = new ArrayList<Person>();
		peopleOver25 = main.elderThan25(people);

		for (Person name1 : peopleOver25) {
			System.out.println(name1);
		}

	}

	public List<Person> elderThan25(List<Person> persons) {
		List<Person> newList = new ArrayList<Person>();

		for (Person person : persons) {

			if (person.getAge() >= 25) {
				newList.add(person);
			}
		}

		for (int person = 0; person < persons.size(); person++) {
			persons.get(person).getAge();

		}
		return newList;

	}

}
