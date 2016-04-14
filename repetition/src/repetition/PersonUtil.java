package repetition;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {

	public List<String> getNavneOver25(List<Person> personer) {
		List<String> elderThan25 = new ArrayList<String>();

		for (Person person : personer) {
			if (person.getAge() > 25) {
				elderThan25.add(person.getName());
			}
		}
		return elderThan25;
	}

}