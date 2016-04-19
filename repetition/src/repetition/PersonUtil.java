package repetition;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {
	public static List<String> getElderThan25(List<Person> persons) {
		List<String> elderThan25 = new ArrayList<String>();

			for (Person person : persons) {
				if (person.getAge() > 25) {
					elderThan25.add("Name: " + person.getName() + " -- " + "Email: " + person.getEmail() + " -- " + "Age: " + person.getAge());
				}

			}
		return elderThan25;

	}
}