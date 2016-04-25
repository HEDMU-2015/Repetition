package logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import data.DataAccess;
import data.PersonDA;
import domain.PersonDomain;

public class Personer {
	
	private final static Personer instance = new Personer();
	private Map<String, PersonDomain> personer = new HashMap<>();
	private PersonDA personda = new PersonDA();
	
	private Personer() {
		DataAccess dataaccess = new DataAccess();
		List<PersonDomain> list = new LogicTrans<List<PersonDomain>>(dataaccess)
			.transaction(() -> personda.list(dataaccess, ""));	
		
		for (PersonDomain p : list) {
			personer.put(p.getEmail(), p);
		}
	}
	
	public static Personer instance() {
		return instance;
	}
	
	public void create(PersonDomain p) {
		personer.put(p.getEmail(), p);
	}
	
	public Optional<PersonDomain> read(String email) {
		PersonDomain p = personer.get(email);
		if (p != null) {
			return Optional.of(p);
		} else {
			return Optional.empty();
		}
	}
	
	public void update(PersonDomain p) {
		personer.replace(p.getEmail(), p);
	}
	
	public void delete(PersonDomain p) {
		personer.remove(p.getEmail());
	}

	public List<PersonDomain> list(String search) {
		return personer.values()
				.stream()
				.filter(p -> p.getName().toUpperCase().contains(search.toUpperCase()) 
						|| p.getEmail().toUpperCase().contains(search.toUpperCase()))
				.collect(Collectors.toList());
	}
}
