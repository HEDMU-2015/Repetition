package repetition;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.sun.org.apache.xpath.internal.functions.Function;

import dataAccess.CreateStatements;
import dataAccess.DataAccessForSQL;


public class Main {
	/**
	 * @author mzk
	 * @throws SQLException 
	 */
	
	public static void main(String[] args) throws SQLException {
		//CreateStatements createStatements = new CreateStatements();
		
		//createStatements.createPerson();
		//createStatements.createEmployement();
		DataAccessForSQL da = new DataAccessForSQL();
		CrudPerson cp = new CrudPerson();
		Person ps = new Person("HAHAHAHA","Email",LocalDate.of(1995, 01, 01));
		//cp.create(da,ps);
		System.out.println(cp.read(da).toString());
		ps.setID(2);
		//cp.update(da, ps);
		cp.delete(da, ps);
		
		
	   
		
		/*Person p;
		List<Person> personer = new ArrayList<Person>();
		Main m = new Main();

		personer.add(p = new Person("Martin", "Martin@email.dk", LocalDate.of(1995, 07, 17)));
		personer.add(p = new Person("Ole", "Ole@email.dk", LocalDate.of(1960, 05, 13)));
		personer.add(p = new Person("Jens", "Jens@email.dk", LocalDate.of(1985, 12, 31)));
		personer.add(p = new Person("Kim", "Kim@email.dk", LocalDate.of(2010, 12, 24)));
		personer.add(p = new Person("Birgit", "email@email.dk", LocalDate.of(1974, 01, 01)));
		personer.add(p = new Person("Kaj", "kaj@email.dk", LocalDate.of(1998, 9, 11)));

		System.out.println("All persons:");
		for (Person pe : personer) {
			System.out.println(pe.toString());
		}

		System.out.println();
		System.out.println("Persons older than 25:");

		for (Person pe : m.elderThan25(personer)) {
			System.out.println(pe.toString());
		}

		Util<Person, String> utility = new Util<>();
		Util<Person, Person> utility2 = new Util<>();
		

		System.out.println("imellem 10 og 20 2010 1/1:  "
				+ utility.reduce1(personer, pl -> pl.getAgeAt(LocalDate.of(2010, 1, 1)) <= 20 && pl.getAgeAt(LocalDate.of(2010, 1, 1))>=10, pr -> pr.getName())); // reduce1

		System.out.println("under 30 2020 1/1 " + utility2.reduce2(personer, pr -> pr,
				pl -> pl.getAgeAt(LocalDate.of(2020, 1, 1)) < 30)); // reduce2
				
				*/

	}

	public List<Person> elderThan25(List<Person> personer) {
		List<Person> elderThan25list = new ArrayList<Person>();
		for (Person p : personer) {
			if (p.getAge() > 25) {
				elderThan25list.add(p);
			}
		}
		return elderThan25list;
	}
	
	public static java.sql.Date convertDate(
            LocalDate localDate) {
        java.sql.Date sqlDate = null;
        if (localDate != null) {
            sqlDate = Date.valueOf(localDate);
        }
        return sqlDate;
    }

}