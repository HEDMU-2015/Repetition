package repetition.opgava4;

import java.util.ArrayList;
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
	private static Map<String, Person> cache; // if it is wish  = new ConcurrentHashMap <>(); here : gives ExceptionInInitializerError
	private PersonMapper personMapper = new PersonMapper();
	private List<Person> list;

	private Personer(){
		DataAccess dataAccess = new DataAccess();
		cache = new ConcurrentHashMap <>();
		list = new LogicTrans<List<Person>>(dataAccess).transaction(()-> personMapper.getList(dataAccess));
		for(Person p : list){
			cache.put( p.getEmail(), p);			
		}		
	}
	

	public static Personer instance(){
		return personer;
	}

	public void create(String email, Person person){
		cache.put(email, person);
		DataAccess dataAccess = new DataAccess();
		new LogicTrans<Person>(dataAccess).transaction(()-> personMapper.create(dataAccess, person));
	}

	public Person read(String email){
		
		return cache.get(email);
	}

	public void update(String email, Person person){
		cache.replace(email, person);
		DataAccess dataAccess = new DataAccess();
		new LogicTrans<Person>(dataAccess).transaction(()-> personMapper.update(dataAccess, person));

	}

	public void delete(String email){
		cache.remove(email);
		DataAccess dataAccess = new DataAccess();
		new LogicTrans<>(dataAccess).transaction(()-> personMapper.delete(dataAccess, email));
	}
	
	
//************************** extra thing *****************************
	public List<Person> search (String key){

		List<Person> result = new ArrayList<>();

		for(Person p : getList()){
			if(matcher(p.getName(), key) ||  matcher(p.getEmail(), key) || (matcher(p.getBirthday().toString(), key))){
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
