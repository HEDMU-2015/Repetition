package newPerson;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Jeppe", "jeppe@mail.com", LocalDate.of(1995, 6, 15)),
				new Person("Jacob", "jacob@mail.com", LocalDate.of(1999, 7, 7)),
				new Person("Jesper", "jesper@mail.com", LocalDate.of(1966, 7, 11)),
				new Person("Jens", "jens@mail.com", LocalDate.of(1967, 9, 30)),
				new Person("Jes", "jes@mail.com", LocalDate.of(1940, 3, 23)),
				new Person("Steen", "steen@mail.com", LocalDate.of(1990, 3, 20)),
				new Person("Annette", "annette@mail.com", LocalDate.of(1980, 4, 30)),
				new Person("Elly", "elly@mail.com", LocalDate.of(1975, 3, 26)),
				new Person("Søren", "søren@mail.com", LocalDate.of(1935, 9, 27)),
				new Person("Bodil", "bodil@mail.com", LocalDate.of(1975, 8, 13)),
				new Person("Frede", "frede@mail.com", LocalDate.of(2005, 7, 9)),
				new Person("Lone", "lone@mail.com", LocalDate.of(2003, 3, 7)),
				new Person("Kim", "kim@mail.com", LocalDate.of(2015, 2, 5)));
		System.out.println(new Main().elderThan25(persons) + " \n");
		System.out.println(new Main().youngerThan30(persons) + " \n");
		System.out.println(new Main().between10and20(persons) + " \n");
		
	}	
	public List<Person> elderThan25(List<Person> persons) {
		return persons.stream().filter(p -> p.getAge() > 25).collect(Collectors.toList());
	}

	public List<Person> youngerThan30(List<Person> persons) {
		return persons.stream()
				.filter(p -> p.getAgeAt(LocalDate.of(2020, 1, 1)) >= 0 && p.getAgeAt(LocalDate.of(2010, 1, 1)) < 30)
				.collect(Collectors.toList());
	}

	public List<Person> between10and20(List<Person> persons) {
		return persons.stream()
				.filter(p -> p.getAgeAt(LocalDate.of(2010, 1, 1)) >= 10 && p.getAgeAt(LocalDate.of(2010, 1, 1)) <= 20)
				.collect(Collectors.toList());
	}

}