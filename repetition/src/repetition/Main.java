package repetition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		List<Person>persons = new ArrayList<Person>();
		Person p1 = new Person("Marina ","@gmail.com",LocalDate.of(2000, 2, 16));
		Person p2 = new Person("Anders ","dsa",LocalDate.of(1960, 7, 22));
		Person p3 = new Person("Knud ","dsad",LocalDate.of(2010, 12, 10));
		Person p4 = new Person("Sara ","dsad",LocalDate.of(1987, 4, 2));
		Person p5 = new Person("Susanne ","dsadsa",LocalDate.of(1978, 9, 3));
		Person p6 = new Person("Marianne ","@gmail.com",LocalDate.of(1995, 3, 16));
		Person p7 = new Person("Andersine ","dsa",LocalDate.of(1967, 7, 22));
		Person p8 = new Person("Rene ","dsad",LocalDate.of(2006, 12, 10));
		Person p9 = new Person("Sarah ","dsad",LocalDate.of(1989, 4, 2));
		Person p10 = new Person("Susanne ","dsadsa",LocalDate.of(1979, 9, 3));
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		persons.add(p5);
		persons.add(p6);
		persons.add(p7);
		persons.add(p8);
		persons.add(p9);
		persons.add(p10);
		
//		System.out.println(persons);
	Main m = new Main();
	m.elderThan25(persons);
	}
	
	public List<Person> elderThan25(List<Person> persons) {
		List<Person>elderThan25 = new ArrayList<>();
		
		for (Person person : persons) {
			if(person.getAge()>25){
				elderThan25.add(person);
			}
				
		}
		System.out.println(elderThan25);
		return elderThan25;
	}

}
