package repetition;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main2 {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person.Builder().setName("Hans").setEmail("hi@eamv.dk").setBirthdate(LocalDate.of(1951, 3, 1)).build(),
				new Person.Builder().setName("Margit").setEmail("margit@eamv.dk").setBirthdate(LocalDate.of(1991, 4, 20)).build(),
				new Person.Builder().setName("Marie").setEmail("marie@eamv.dk").setBirthdate(LocalDate.of(1991, 4, 21)).build(),
				new Person.Builder().setName("Anne").setEmail("anne@eamv.dk").setBirthdate(LocalDate.of(1991, 4, 22)).build(),
				new Person.Builder().setName("Søren").setEmail("soren@eamv.dk").setBirthdate(LocalDate.of(1994, 4, 12)).build()
				);
		
		System.out.println(new Main2().elderThan25(persons));

	}
	public List<Person> elderThan25(List<Person> persons) {
		Stream<Person> s1 = persons.stream();
		Stream<Person> s2 = s1.filter(p -> p.getAge() > 25);
		List<Person> result = s2.collect(toList());
		return result;
	}

}
