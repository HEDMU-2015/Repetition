package repetition.opgava4;

import java.util.List;
import java.time.LocalDate;
/**
 * 
 * @author Juyoung Choi
 *
 */

public class Main {

	public static void main(String[] args) {

		new Main().lavList();
		
		System.out.println("List : " + Personer.instance().getList());

		System.out.println("\n***********************************************\n");

		System.out.println(Personer.instance().read("juy@me.com"));
		
		System.out.println(Personer.instance().search("U"));
			
		System.out.println("\n***********************************************\n");

		List<Person> persons = Personer.instance().getList();
				
		Util<Person, Person> util = new Util<>();
		System.out.println("UTIL 25 år med anden metode : " 
				+ util.reduce(persons,
						(Person p) -> p, 
						p -> Util.differentInYears(p.getBirthday(), LocalDate.now())> 25
						));

		Util<Person,String> util1 = new Util<>();
		System.out.println("UTIL 10-20 år : " 				
				+ util1.reduce(persons,
						(Person p) ->Util.differentInYears(p.getBirthday(),LocalDate.of(2020, 01, 01))<20 
						&& Util.differentInYears(p.getBirthday(),LocalDate.of(2020, 01, 01))>10,
						p -> p.getName()));

		Util<Person, Person> util2 = new Util<>();
		System.out.println("UTIL 30 år : " 
				+ util2.reduce(persons, 
						(Person p) -> p,
						p-> Util.differentInYears(p.getBirthday(),LocalDate.of(2010, 01, 01)) > 30));
		
	}


	private void lavList(){

		Personer.instance().create("juy@me.com", new Person.Builder("Juyoung", "juy@me.com", LocalDate.of(1982,01,17)).build());
		Personer.instance().create("jesp@me.com", new Person.Builder("Jesper", "jesp@me.com", LocalDate.of(1974,07,18)).build());
		Personer.instance().create("mina@me.com", new Person.Builder("Mina", "mina@me.com", LocalDate.of(2010,02,17)).build());
		Personer.instance().create("kim@me.com", new Person.Builder("Kim", "kim@me.com", LocalDate.of(2000,12,17)).build());
		Personer.instance().create("park@me.com", new Person.Builder("Park", "park@me.com", LocalDate.of(1990,02,22)).build());

		
	}


}


