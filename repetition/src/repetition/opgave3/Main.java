package repetition.opgave3;

//import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		PersonLogic personLogic = new PersonLogic();
//		Person person = new Person("Dean", "dean@me.com", LocalDate.of(1970,02,03));
//		personLogic.create(person);
		
		System.out.println(personLogic.read(6));
		
		
	}

}
