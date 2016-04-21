package logic;

import domain.Employment;
import domain.Person;

public interface CrudController {

	public void createPerson(Person person);

	public void deletePerson(Person person);

	public Person Person(int id);

	public void updatePerson(Person person);

	public void createEmployment(Employment employment);

	public void deleteEmployment(Employment employment);

	public Employment readEmployment(int id);

	public void updateEmployment(Employment employment);

}
