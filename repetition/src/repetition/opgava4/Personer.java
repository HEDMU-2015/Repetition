package repetition.opgava4;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Personer {
	
	private static Personer personer = new Personer();
	private Map<String, Person> map = new HashMap();
	
	private Personer(){
		
	}
	
	public static Personer instance(){
		return personer;
	}
	
	public void create(){
		
	}
	
	public Optional<Person> read(){
		return null;
	}
	
	public void update(){
		
	}
	
	public void delete(){
		
	}
}
