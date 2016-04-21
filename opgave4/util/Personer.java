package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.PersonBuilder;
import persistence.Crud2;
import persistence.CrudPersonMapper2;
import persistence.DataAccess;
import persistence.DataAccessImpl;

public class Personer {

	private static Personer personer = new Personer();

	private Crud2<PersonBuilder, String> crudPersonMapper2;
	private Map<String, PersonBuilder> cache = new HashMap<>();

	private Personer() {
		DataAccess dataAccess = null;
		List<PersonBuilder> persons = new ArrayList<>();
		try {
			dataAccess = new DataAccessImpl();
			persons = crudPersonMapper2.persons(dataAccess);
			for (PersonBuilder person : persons) {
				cache.put(person.getName(), person);
			}
		} catch (Exception e) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
	}

	public static Personer getInstance() {
		return Personer.personer;
	}

	public void createPerson(PersonBuilder person) {
		DataAccess dataAccess = null;
		crudPersonMapper2 = new CrudPersonMapper2();
		try {
			dataAccess = new DataAccessImpl();
			crudPersonMapper2.create(dataAccess, person);
			dataAccess.commit();
			cache.put(person.getName(), person);
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
	}

	public void deletePerson(PersonBuilder person) {
		DataAccess dataAccess = null;
		crudPersonMapper2 = new CrudPersonMapper2();
		try {
			dataAccess = new DataAccessImpl();
			crudPersonMapper2.delete(dataAccess, person);
			dataAccess.commit();
			cache.remove(person.getName());
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
	}

	public PersonBuilder readPerson(String id) {
		DataAccess dataAccess = null;
		crudPersonMapper2 = new CrudPersonMapper2();
		PersonBuilder person = null;
		try {
			dataAccess = new DataAccessImpl();
			person = crudPersonMapper2.read(dataAccess, id);
			cache.get(id);
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
		return person;
	}

	public void updatePerson(PersonBuilder person) {
		DataAccess dataAccess = null;
		crudPersonMapper2 = new CrudPersonMapper2();
		try {
			dataAccess = new DataAccessImpl();
			crudPersonMapper2.update(dataAccess, person);
			dataAccess.commit();
			cache.replace(person.getName(), person);
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}

	}
	
}
