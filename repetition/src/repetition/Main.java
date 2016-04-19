package repetition;
/*Færdiggør metoden "elderThan25" i Main-klassen
- Den skal reducere input-listen, så kun personer ældre end 25 år returneres.*/

import java.security.Permissions;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* Udfyld main-metoden med følgende:
 - Lav en List<Person> med mindst 5 Person-objekter, som er født mellem 1960 og 2010
 - Udskriv listen
 - Kald metoden "elderThan25"
 - Udskriv resultatet (System.out)*/


import java.util.List;

public class Main {
	int a = 25;

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Line", "email", LocalDate.of(1960, 17, 10)),
				new Person("Erik", "email", LocalDate.of(1980, 17, 10)),
				new Person("Thomas", "email", LocalDate.of(1990, 17, 10)),
				new Person("Lise", "email", LocalDate.of(2000, 17, 10)),
				new Person("Hans", "email", LocalDate.of(2010, 17, 10))
				);
		System.out.println(new Main().elderThan25(persons));
	}
	
	public List<Person> elderThan25(List<Person> persons) {
		List<Person> result = new ArrayList<>();
		Iterator<Person> it = persons.iterator();
		
			while(it.hasNext()){
				Person p = it.next();
				
				if(p.getAge() >= 25){
					result.add(p);
				}
			}
		return result;
	}
	
}
