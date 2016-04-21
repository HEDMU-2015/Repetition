package logic;

import domain.PersonBuilder;

public interface CrudController2 {

	public void createPerson(PersonBuilder person);

	public void deletePerson(PersonBuilder person);

	public PersonBuilder readPerson(String id);

	public void updatePerson(PersonBuilder person);

}
