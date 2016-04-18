package repetition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import sun.security.pkcs11.wrapper.Functions;
/**
 * 
 * @author Juyoung Choi
 *
 */
public class Main {

	public static void main(String[] args) {
	
		Main main = new Main();
		List<Person> persons = main.lavList();
		System.out.println("List : " + persons);
		System.out.println("***********************************************");
		System.out.println("main method trial 25 år : " + main.elderThan25(persons));
		System.out.println("main method trial 10-20 år : " + main.elder10til20(persons));
		System.out.println("main method trial 30 år : " + main.elder30(persons));
		System.out.println("***********************************************");

		Util<Person, List<Person>> util0 = new Util<>();
		System.out.println("UTIL 25 år : " 
				+ util0.reduce(persons,
				(Person p) -> p.getAge()> 25,  // without case(Person p) : ambiguity error
				p -> Arrays.asList(new Person(p.getName(), p.getEmail(), p.getBirthdate()))));
		
		Util<Person,String> util1 = new Util<>();
		System.out.println("UTIL 10-20 år : " 				
				+ util1.reduce(persons,
				(Person p) -> p.getAgeAt(LocalDate.of(2020, 01, 01))<20 && p.getAgeAt(LocalDate.of(2020, 01, 01))>10,
				p -> p.getName()));
		
		Util<Person, List<Person>> util2 = new Util<>();
		System.out.println("UTIL 30 år : " 
				+ util2.reduce(persons,
				(Person p) -> p.getAgeAt(LocalDate.of(2010, 01, 01))>30, 
				p -> Arrays.asList(new Person(p.getName(), p.getEmail(), p.getBirthdate()))));
			
	}
	
	private List<Person> elderThan25(List<Person> persons) {
		return persons
				.stream()
				.filter(person -> person.getAge()>25)
				.collect(Collectors.toList());		
		
	}
	
	private List<String> elder10til20(List<Person> persons){
		return persons
				.stream()
				.filter( p-> p.getAgeAt(LocalDate.of(2020, 01, 01))<20&&p.getAgeAt(LocalDate.of(2020, 01, 01))>10)
				.map(p->p.getName())
				.collect(Collectors.toList());		
	}	
	
	private List<Person> elder30(List<Person> persons){
		return persons
				.stream()
				.filter(p-> p.getAgeAt(LocalDate.of(2010, 01, 01))>30)	
				.map(p-> new Person(p.getName(), p.getEmail(), p.getBirthdate()))
				.collect(Collectors.toList());

	}
	
	private List<Person> lavList(){
		
		List <Person> personList = new ArrayList<>();
		personList.add(new Person("Juyoung", "juy@me.com", LocalDate.of(1982,01,17)));
		personList.add(new Person("Jesper", "jesp@me.com", LocalDate.of(1974,07,18)));
		personList.add(new Person("Mina", "mina@me.com", LocalDate.of(2010,02,17)));
		personList.add(new Person("Kim", "kim@me.com", LocalDate.of(2000,12,17)));
		personList.add(new Person("Park", "park@me.com", LocalDate.of(1990,02,22)));
		
		return personList;
	}

}
