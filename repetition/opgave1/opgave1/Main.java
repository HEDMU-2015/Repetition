package opgave1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Dennis", LocalDate.of(1993, 9, 23)));
		persons.add(new Person("Katharina", LocalDate.of(1995, 10, 10)));
		persons.add(new Person("Bent", LocalDate.of(1983, 1, 17)));
		persons.add(new Person("Kurt", LocalDate.of(1970, 3, 14)));
		persons.add(new Person("Birthe", LocalDate.of(1975, 12, 7)));
		persons.add(new Person("Hans", LocalDate.of(2000, 2, 9)));
		persons.add(new Person("Anders", LocalDate.of(2001, 1, 2)));
		persons.add(new Person("Pernille", LocalDate.of(1990, 11, 27)));
		persons.add(new Person("Verner", LocalDate.of(1966, 5, 12)));
		persons.add(new Person("Lisette", LocalDate.of(1987, 6, 15)));
		System.out.println(persons);

		PersonUtil personUtil = new PersonUtil();
		List<String> names = personUtil.getNamesOver25(persons);
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
	}
	
}