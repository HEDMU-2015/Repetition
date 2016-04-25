package repetition;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import domain.PersonDomain;
import logic.PersonLogic;

public class Main {

	public static void main(String[] args) {
//		List<Person> persons = Arrays.asList(
//				new Person.Builder().setName("Hans").setEmail("hi@eamv.dk").setBirthdate(LocalDate.of(1951, 3, 1)).build(),
//				new Person.Builder().setName("Margit").setEmail("margit@eamv.dk").setBirthdate(LocalDate.of(1991, 4, 9)).build(),
//				new Person.Builder().setName("Marie").setEmail("marie@eamv.dk").setBirthdate(LocalDate.of(1991, 4, 10)).build(),
//				new Person.Builder().setName("Anne").setEmail("anne@eamv.dk").setBirthdate(LocalDate.of(1991, 4, 11)).build(),
//				new Person.Builder().setName("Søren").setEmail("soren@eamv.dk").setBirthdate(LocalDate.of(1994, 4, 12)).build()
//				);
		PersonLogic pl = new PersonLogic();
		List<PersonDomain> persons = pl.list("");
		System.out.println(new Main().elderThan25(persons));
		
		Util<PersonDomain, PersonDomain> util1 = new Util<>();
		Predicate<PersonDomain> predicate1 = p -> {
				LocalDate date = LocalDate.of(2020, 1, 1);
				int age = p.getAgeAt(date);
				return age < 30;
		};
		System.out.println(util1.reduce(persons, predicate1, p -> p));
		
		Util<PersonDomain, String> util2 = new Util<>();
		Predicate<PersonDomain> predicate2 = new Predicate<PersonDomain>() {

			@Override
			public boolean test(PersonDomain t) {
				LocalDate date = LocalDate.of(2010, 1, 1);
				int age = t.getAgeAt(date);
				return age > 10 && age < 20;
			}
		}; 
//				p -> {
//				LocalDate date = LocalDate.of(2010, 1, 1);
//				int age = p.getAgeAt(date);
//				return age > 10 && age < 20;
//		};
		System.out.println(util2.reduce(persons, predicate2, p -> p.getName()));
		
	}
	
	public List<PersonDomain> elderThan25(List<PersonDomain> persons) {
		return persons
				.stream()
				.filter(p -> p.getAge() > 25)
				.collect(Collectors.toList());
	}

}
