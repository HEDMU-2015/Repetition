package repetition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Juyoung Choi
 *
 */
public class Main {

	public static void main(String[] args) {
	
		Main main = new Main();
		List<Person> persons = main.lavList();
		System.out.println(main.elderThan25(persons));
	
	}
	
	public List<Person> elderThan25(List<Person> persons) {
		
		List<Person> listElderThan25 = new ArrayList<>();
		for(Person p : persons){
			if(p.getAge().getYears()>25){
				listElderThan25.add(p);
			}
		}
		
		return listElderThan25;
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
