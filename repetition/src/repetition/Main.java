package repetition;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Hans", "hi@eamv.dk", LocalDate.of(1951, 3, 1)),
				new Person("Margit", "margit@eamv.dk", LocalDate.of(1991, 4, 9)),
				new Person("Marie", "marie@eamv.dk", LocalDate.of(1991, 4, 10)),
				new Person("Anne", "anne@eamv.dk", LocalDate.of(1991, 4, 11)),
				new Person("Søren", "soren@eamv.dk", LocalDate.of(1994, 4, 12))
				);
		System.out.println(new Main().elderThan25(persons));
		
		Util<Person, Person> util1 = new Util<>();
		Predicate<Person> predicate1 = p -> {
				LocalDate date = LocalDate.of(2020, 1, 1);
				int age = p.getAgeAt(date);
				return age < 30;
		};
		System.out.println(util1.reduce(persons, predicate1, p -> p));
		
		Util<Person, String> util2 = new Util<>();
		Predicate<Person> predicate2 = p -> {
				LocalDate date = LocalDate.of(2010, 1, 1);
				int age = p.getAgeAt(date);
				return age > 10 && age < 20;
		};
		System.out.println(util2.reduce(persons, predicate2, p -> p.getName()));
		
	}
	
	public List<Person> elderThan25(List<Person> persons) {
		return persons
				.stream()
				.filter(p -> p.getAge() > 25)
				.collect(Collectors.toList());
	}

}
