package repetition;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Jeppe", "jeppe@mail.com", LocalDate.of(1995, 6, 15)));
		persons.add(new Person("Jacob", "jacob@mail.com", LocalDate.of(1999, 7, 7)));
		persons.add(new Person("Jesper", "jesper@mail.com", LocalDate.of(1966, 7, 11)));
		persons.add(new Person("Jens", "jens@mail.com", LocalDate.of(1967, 9, 30)));
		persons.add(new Person("Jes", "jes@mail.com", LocalDate.of(1940, 3, 23)));
		persons.add(new Person("Steen", "steen@mail.com", LocalDate.of(1990, 3, 20)));
		persons.add(new Person("Annette", "annette@mail.com", LocalDate.of(1980, 4, 30)));
		persons.add(new Person("Elly", "elly@mail.com", LocalDate.of(1975, 3, 26)));
		persons.add(new Person("Søren", "søren@mail.com", LocalDate.of(1935, 9, 27)));
		persons.add(new Person("Bodil", "bodil@mail.com", LocalDate.of(1975, 8, 13)));
		persons.add(new Person("Frede", "frede@mail.com", LocalDate.of(2005, 7, 9)));
		persons.add(new Person("Lone", "lone@mail.com", LocalDate.of(2003, 3, 7)));
		persons.add(new Person("Kim", "kim@mail.com", LocalDate.of(2015, 2, 5)));
		
		List<String> people = PersonUtil.getElderThan25(persons);
		for ( int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
			}
	

		
	}

}