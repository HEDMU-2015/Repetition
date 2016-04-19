package repetition.opgava4;
/**
 * 
 * @author Juyoung Choi
 *
 */

public class PersonLogic implements CRUD<Person, String> {
	
	public void create(Person person){
		Personer.instance().create(person.getEmail(), person);
	}
	
	public Person read(String email){
		return Personer.instance().read(email);
	}
	
	public void update (Person person){
		Personer.instance().update(person.getEmail(), person);
	}
	
	public void delete(Person person){
		Personer.instance().delete(person.getEmail());		
	}
}
