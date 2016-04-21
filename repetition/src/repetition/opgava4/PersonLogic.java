package repetition.opgava4;

import java.util.List;

/**
 * 
 * @author Juyoung Choi
 *
 */

public class PersonLogic implements CRUD<Person, String> {
	
	public List<Person> search (String key){
		return Personer.instance().search(key);
	}
	
	public List<Person> getList(){
		return Personer.instance().getList();
	}

	
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
