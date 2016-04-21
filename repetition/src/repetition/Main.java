package repetition;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	


	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Jonas", "shadow@lantea.dk", LocalDate.of(1989, 11, 24)),
				new Person("Steffen", "svmoritar@gmail.com", LocalDate.of(1987, 3, 9)),
				new Person("Rollo", "rollo@lantea.dk", LocalDate.of(2015, 8, 16)),
				new Person("The Raven Guard", "???", LocalDate.of(2015, 10, 8)),
				new Person("End of all Hope", "Cyprus", LocalDate.of(2015, 4, 1)));
		System.out.println(new Main().elderThan25(persons));

	}

	public List<Person> elderThan25(List<Person> persons) {
		return persons.stream().filter(p -> p.getAge() > 25).collect(Collectors.toList());
	}
}
