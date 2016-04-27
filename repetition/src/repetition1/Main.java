package repetition1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Main neededForPrint = new Main();
		Util<Person, Person> util = new Util<>();
		List<Person> personer = new ArrayList<>();
		List<Person> personOver25 = new ArrayList<>();

		Person kurt = new Person("Kurt", "kurt@gmail.com", LocalDate.of(1960, 12, 1));
		Person bent = new Person("Bent", "bent@gmail.com", LocalDate.of(1965, 12, 1));
		Person ib = new Person("Ib", "ib@gmail.com", LocalDate.of(1970, 12, 1));
		Person bo = new Person("Bo", "bo@gmail.com", LocalDate.of(1975, 12, 1));
		Person karl = new Person("Karl", "karl@gmail.com", LocalDate.of(1980, 12, 1));
		Person niels = new Person("Niels", "niels@gmail.com", LocalDate.of(1985, 12, 1));
		Person erik = new Person("Erik", "erik@gmail.com", LocalDate.of(1990, 12, 1));
		Person dennis = new Person("Dennis", "dennis@gmail.com", LocalDate.of(1995, 12, 1));
		Person rasmus = new Person("Rasmus", "rasmus@gmail.com", LocalDate.of(2000, 12, 1));
		Person brian = new Person("Brian", "brian", LocalDate.of(2005, 12, 1));
		Person martin = new Person("Martin", "martin@gmail.com", LocalDate.of(2010, 12, 1));
		Person daniel = new Person("Daniel", "daniel@gmail.com", LocalDate.of(1989, 12, 1));
		Person steffen = new Person("Steffen", "steffen@gmail.com", LocalDate.of(1978, 12, 1));
		Person jeppe = new Person("Jeppe", "jeppe@gmail.com", LocalDate.of(1999, 12, 1));

		personer.add(kurt);
		personer.add(bent);
		personer.add(ib);
		personer.add(bo);
		personer.add(karl);
		personer.add(niels);
		personer.add(erik);
		personer.add(dennis);
		personer.add(rasmus);
		personer.add(brian);
		personer.add(martin);
		personer.add(daniel);
		personer.add(steffen);
		personer.add(jeppe);

		System.out.println("Alle personer: " + personer.size());
		for (Person p : personer) {
			System.out.println(p);
		}

		// opgave 1
		personOver25 = neededForPrint.elderThan25(personer);
		System.out.println("\nPersoner over 25: " + personOver25.size());
		for (Person p : personOver25) {
			System.out.println(p);
		}

		//opgave 2
		System.out.println("\nPersoner under 30: ");
		System.out.println(util.reduce1(personer, p -> p.getAgeAt(LocalDate.of(2020, 1, 1)) < 30, p -> p));
		
		System.out.println("\nPersoner mellem 10 og 20: ");
		System.out.println(util.reduce2(personer, p -> p, p -> p.getAgeAt(LocalDate.of(2010, 1, 1)) > 10 && p.getAgeAt(LocalDate.of(2010, 1, 1)) < 20 ));
		
		
		
	}

	public List<Person> elderThan25(List<Person> persons) {
		
		List<Person> personOver25 = new ArrayList<>();

		for (Person p : persons) {
			if (p.getAge() > 25) {
				personOver25.add(p);
			}
		}
		return personOver25;
	}

}
