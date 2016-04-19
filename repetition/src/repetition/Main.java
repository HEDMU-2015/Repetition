package repetition;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.sun.org.apache.xpath.internal.functions.Function;

public class Main {
	/**
	 * @author mzk
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Person p;
		List<Person> personer = new ArrayList<Person>();
		Main m = new Main();

		personer.add(p = new Person("Martin", "Martin@email.dk", LocalDate.of(1995, 07, 17)));
		personer.add(p = new Person("Ole", "Ole@email.dk", LocalDate.of(1960, 05, 13)));
		personer.add(p = new Person("Jens", "Jens@email.dk", LocalDate.of(1985, 12, 31)));
		personer.add(p = new Person("Kim", "Kim@email.dk", LocalDate.of(2010, 12, 24)));
		personer.add(p = new Person("Birgit", "email@email.dk", LocalDate.of(1974, 01, 01)));
		personer.add(p = new Person("Kaj", "kaj@email.dk", LocalDate.of(2001, 9, 11)));

		System.out.println("All persons:");
		for (Person pe : personer) {
			System.out.println(pe.toString());
		}

		System.out.println();
		System.out.println("Persons older than 25:");

		for (Person pe : m.elderThan25(personer)) {
			System.out.println(pe.toString());
		}

		Util<Person, Person> utility = new Util<>();

		System.out.println("under 30 2020 1/1: "
				+ utility.reduce1(personer, pl -> pl.getAgeAt(LocalDate.of(2020, 1, 1)) < 30, pr -> pr)); // reduce1

		System.out.println("imellem 10 og 20 2010 1/1: " + utility.reduce2(personer, pr -> pr,
				pl -> pl.getAgeAt(LocalDate.of(2010, 1, 1)) < 20 && pl.getAge() > 10)); // reduce2

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