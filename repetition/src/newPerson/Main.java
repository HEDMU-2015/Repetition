package newPerson;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
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
		
	}	
	public List<Person> elderThan25(List<Person> persons) {
		return persons
				.stream()
				.filter(p -> p.getAge() > 25)
				.collect(Collectors.toList());
	}

}