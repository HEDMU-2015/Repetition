package repetition.opgava4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import java.util.concurrent.ConcurrentHashMap;
/**
 * 
 * @author Juyoung Choi
 *
 */

public class Personer {
	
	private static Personer personer = new Personer();
	private static final Map<String, Person> cache = new HashMap <>();
	
	private Personer(){
		
	}
	
	public static Personer instance(){
		return personer;
	}
	
	public void create(String email, Person person){
		cache.put(email, person);
	}
	
	public Person read(String email){
		return cache.get(email);
	}
	
	public void update(String email, Person person){
		cache.replace(email, person);
	}
	
	public void delete(String email){
		cache.remove(email);
	}
	
	public List<Person> getList(){
		List<Person> list = new ArrayList<>();
		
		for(Map.Entry<String, Person> entry : cache.entrySet()){
			list.add(entry.getValue());
		}
		
		return list;
	}
}
