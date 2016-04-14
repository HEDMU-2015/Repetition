package repetition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Person alina = new Person("Alina", "ali@gmail.com", LocalDate.of(2014, 03, 8));
		Person aurelia = new Person("Aurelia", "aur@gmail.com", LocalDate.of(2013, 07, 23));
		Person lea = new Person("Lea", "lea@gmail.com", LocalDate.of(1997, 07, 21));
		Person amalie = new Person("Amalie", "ama@gmail.com", LocalDate.of(1994, 05, 23));
		Person sebastian = new Person("Sebastian", "seb@gmail.com", LocalDate.of(1994, 9, 8));
		Person rune = new Person("Rune", "run@gmail.com", LocalDate.of(1985, 04, 23));
		Person finn = new Person("Finn", "fin@gmail.com", LocalDate.of(1964, 03, 05));
		Person kerstin = new Person("Kerstin", "ker@gmail.com", LocalDate.of(1961, 10, 05));
		Person helga = new Person("Helga", "hel@gmail.com", LocalDate.of(1935, 03, 9));
		Person jørgen = new Person("Jørgen", "jor@gmail.com", LocalDate.of(1932, 06, 30));

		ArrayList<Person> familie = new ArrayList<Person>();

		familie.add(alina);
		familie.add(aurelia);
		familie.add(lea);
		familie.add(amalie);
		familie.add(sebastian);
		familie.add(rune);
		familie.add(finn);
		familie.add(kerstin);
		familie.add(helga);
		familie.add(jørgen);

		// System.out.println("Listen indeholder følgende 10 familiemedlemmer:"
		// + familie);

		Main ældreEnd25 = new Main();
		ældreEnd25.elderThan25(familie);
	}

	public  List<Person> elderThan25(List<Person> familie) {

		ArrayList<Person> result = new ArrayList<Person>();
		for (Person person : familie) {
			if (person.getAge() > 25) {
				result.add(person);
			}
		}
		System.out.println(result);

		return null;
	}

}
