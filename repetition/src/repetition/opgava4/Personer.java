package repetition.opgava4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;
/**
 * 
 * @author Juyoung Choi
 *
 */

public class Personer {

	private static Personer personer = new Personer();
//  private static final Map<String, Person> cache = new HashMap <>();
//	http://crunchify.com/hashmap-vs-concurrenthashmap-vs-synchronizedmap-how-a-hashmap-can-be-synchronized-in-java/
	private static final Map<String, Person> cache = new ConcurrentHashMap <>();

//	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");



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

	public List<Person> search (String key){

		List<Person> result = new ArrayList<>();

		for(Person p : getList()){
			if(matcher(p.getName(), key) ||  matcher(p.getEmail(), key)){
				result.add(p);
			}			
		}
		return result;
	}

	private boolean matcher(String attribut, String søgeord){

		return attribut.toLowerCase().contains(søgeord.toLowerCase());

	}


	public List<Person> getList(){
		List<Person> list = new ArrayList<>();
		list.addAll(cache.values());
		return list;
	}




	// 		OTHER WAYT TO MAKE LIST FROM HASHMAP
	//		cache.forEach((k,v)-> System.out.println(k+", "+v)); // to print out each k and v
	//		System.out.println(cache.values());
	//		
	//		for(Map.Entry<String, Person> entry : cache.entrySet()){
	//			list.add(entry.getValue());
	//		}
	//		
	//		return list;
}
