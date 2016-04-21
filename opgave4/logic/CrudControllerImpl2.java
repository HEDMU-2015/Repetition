package logic;

import domain.PersonBuilder;
import util.Personer;

public class CrudControllerImpl2 implements CrudController2 {

	@Override
	public void createPerson(PersonBuilder person) {
		Personer.getInstance().createPerson(person);
	}

	@Override
	public void deletePerson(PersonBuilder person) {
		Personer.getInstance().deletePerson(person);
	}

	@Override
	public PersonBuilder readPerson(String id) {
		return Personer.getInstance().readPerson(id);
	}

	@Override
	public void updatePerson(PersonBuilder person) {
		Personer.getInstance().updatePerson(person);
	}

}
