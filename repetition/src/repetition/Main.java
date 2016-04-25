package repetition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Per", "per@gmail.com", LocalDate.of(1988, 12, 15)));
		persons.add(new Person("Søren", "søren@gmail.com", LocalDate.of(2010, 11, 14)));
		persons.add(new Person("Mads", "mads@gmail.com", LocalDate.of(1999, 10, 13)));
		persons.add(new Person("John", "john@gmail.com", LocalDate.of(2010, 9, 12)));
		persons.add(new Person("Mette", "mette@gmail.com", LocalDate.of(1982, 8, 11)));
		persons.add(new Person("Lordes", "lordes@gmail.com", LocalDate.of(1986, 7, 10)));
		persons.add(new Person("Misse", "misse@gmail.com", LocalDate.of(1978, 6, 9)));
		persons.add(new Person("Glen", "glen@gmail.com", LocalDate.of(1953, 5, 8)));
		persons.add(new Person("Benjamin", "benjamin@gmail.com", LocalDate.of(1956, 4, 7)));
		persons.add(new Person("Helene", "helene@gmail.com", LocalDate.of(2012, 3, 6)));
		persons.add(new Person("Jens", "jens@gmail.com", LocalDate.of(1950, 2, 5)));
		persons.add(new Person("Louis", "louis@gmail.com", LocalDate.of(1953, 1, 4)));
		persons.add(new Person("Sara", "sara@gmail.com", LocalDate.of(1955, 12, 3)));
		persons.add(new Person("Pernille", "pernille@gmail.com", LocalDate.of(1957, 11, 2)));
		persons.add(new Person("Dorthe", "dorthe@gmail.com", LocalDate.of(2000, 10, 1)));
		persons.add(new Person("Rene", "rene@gmail.com", LocalDate.of(1999, 9, 30)));
		persons.add(new Person("Karina", "karina@gmail.com", LocalDate.of(1998, 8, 29)));
		persons.add(new Person("Jette", "jette@gmail.com", LocalDate.of(1940, 7, 28)));
		persons.add(new Person("Godfred", "godfred@gmail.com", LocalDate.of(1982, 6, 27)));
		persons.add(new Person("Gudmund", "gudmund@gmail.com", LocalDate.of(1987, 5, 26)));
		
		between10And20(persons);
		youngThan30(persons);
		elderThan25(persons);
		all(persons);
		
	
		
		
	}
	private static void all(List<Person>persons){
		System.out.println("");
		System.out.println("All persons in list");
		System.out.println("");
		
		for (Person person : persons){
			if (person.getAge() >=0){
				System.out.println("age: " + person.getAge() + '\t' + " Birthday: " + person.getBirthdate() + '\t'
						+ " Name: " + person.getName() + '\t' + " Email: " + person.getEmail());
			}
		}
		
	}
	private static void between10And20(List<Person>persons){
		System.out.println("");
		System.out.println("People Between 10 and 20 on 1. january 2010");
		System.out.println("");
		LocalDate date = LocalDate.of(2010, 1, 1);
		for (Person person : persons){
			if (person.getAgeAt(date) <= 20 && person.getAgeAt(date)>=10){
				System.out.println("age: " + person.getAgeAt(date) + '\t' + " Birthday: " + person.getBirthdate() + '\t'
						+ " Name: " + person.getName() + '\t' + " Email: " + person.getEmail());
			}
		}
		
	}
	
	private static void youngThan30(List<Person>persons){
		System.out.println("");
		System.out.println("People younger than 30 on 1. january 2020");
		System.out.println("");
		LocalDate date = LocalDate.of(2020, 1, 1);
		for (Person person : persons){
			if (person.getAgeAt(date) <= 30){
				System.out.println("age: " + person.getAgeAt(date) + '\t' + " Birthday: " + person.getBirthdate() + '\t'
						+ " Name: " + person.getName() + '\t' + " Email: " + person.getEmail());
			}
		}
		
	}

	
	private static  void elderThan25(List<Person>persons) {
		System.out.println("");
		System.out.println("People elder than 25 now");
		System.out.println("");
		for (Person person : persons) {

			if (person.getAge() >= 25) {

				System.out.println("age: " + person.getAge() + '\t' + " Birthday: " + person.getBirthdate() + '\t'
						+ " Name: " + person.getName() + '\t' + " Email: " + person.getEmail());
			}

		}
		
	}

}
