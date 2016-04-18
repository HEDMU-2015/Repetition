package opgave2;

import java.util.List;
import java.util.stream.Collectors;

public class PersonUtil {

	public List<Person> getNamesOver25(List<Person> persons) {
		return persons
				.stream()
				.filter(p -> p.getAge() > 25)
				.collect(Collectors.toList());
	}
	
}