package repetition_Opgave2;
/* Ret Main-klassen, og brug din Liste af personer til følgende:
 - Udskriv en liste af personer, som alle er yngre end 30 år d. 1. januar 2020 (Brug een af reduce-metoderne ovenfor)
 - Udskriv navnene på de personer, som er mellem 10 og 20 år d. 1. januar 2010.
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Main {
	int a = 25;

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Alfred", "email", LocalDate.of(1960, 5, 8)),
				new Person("Line", "email", LocalDate.of(1970, 5, 8)),
				new Person("Hans", "email", LocalDate.of(1980, 5, 8)),
				new Person("Thomas", "email", LocalDate.of(1990, 5, 8)),
				new Person("Anna", "email", LocalDate.of(2000, 5, 8)),
				new Person("Anders", "email", LocalDate.of(2005, 5, 8)),
				new Person("AlfredSine", "email", LocalDate.of(2010, 5, 8)),
				new Person("Trille", "email", LocalDate.of(1989, 5, 8))
				);
		System.out.println(new Main().elderThan25(persons));
	}
	
	public List<Person> elderThan25(List<Person> persons) {
		List<Person> ældreOG25 = new ArrayList<>();
		Iterator<Person> it = persons.iterator();
		
			while(it.hasNext()){
				Person p = it.next();
				
				if(p.getAge() >= 25){
					ældreOG25.add(p);
				}
			}
		return ældreOG25;
	}
	
}
