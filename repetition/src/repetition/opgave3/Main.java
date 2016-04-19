package repetition.opgave3;

//import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		PersonLogic personLogic = new PersonLogic();
//		Person person = new Person("Dean", "dean@me.com", LocalDate.of(1970,02,03));
//		personLogic.creat(person);
		
		System.out.println(personLogic.readOrganisation(6));
		
		
	}

}
