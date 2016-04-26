package logic;

import domain.Employment;
import domain.Person;
import persistence.Crud;
import persistence.CrudEmploymentMapper;
import persistence.CrudPersonMapper;
import persistence.DataAccess;
import persistence.DataAccessImpl;

public class CrudControllerImpl implements CrudController {

	private Crud<Person, Integer> crudPersonMapper;
	private Crud<Employment, Integer> crudEmploymentMapper;

	@Override
	public void createPerson(Person person) {
		DataAccess dataAccess = null;
		crudPersonMapper = new CrudPersonMapper();
		try {
			dataAccess = new DataAccessImpl();
			crudPersonMapper.create(dataAccess, person);
			dataAccess.commit();
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
	}

	@Override
	public void deletePerson(Person person) {
		DataAccess dataAccess = null;
		crudPersonMapper = new CrudPersonMapper();
		try {
			dataAccess = new DataAccessImpl();
			crudPersonMapper.delete(dataAccess, person);
			dataAccess.commit();
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
	}

	@Override
	public Person readPerson(int id) {
		DataAccess dataAccess = null;
		crudPersonMapper = new CrudPersonMapper();
		Person person = null;
		try {
			dataAccess = new DataAccessImpl();
			person = crudPersonMapper.read(dataAccess, id);
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
		return person;
	}

	@Override
	public void updatePerson(Person person) {
		DataAccess dataAccess = null;
		crudPersonMapper = new CrudPersonMapper();
		try {
			dataAccess = new DataAccessImpl();
			crudPersonMapper.update(dataAccess, person);
			dataAccess.commit();
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}

	}

	@Override
	public void createEmployment(Employment employment) {
		DataAccess dataAccess = null;
		crudEmploymentMapper = new CrudEmploymentMapper();
		try {
			dataAccess = new DataAccessImpl();
			crudEmploymentMapper.create(dataAccess, employment);
			dataAccess.commit();
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
	}

	@Override
	public void deleteEmployment(Employment employment) {
		DataAccess dataAccess = null;
		crudEmploymentMapper = new CrudEmploymentMapper();
		try {
			dataAccess = new DataAccessImpl();
			crudEmploymentMapper.delete(dataAccess, employment);
			dataAccess.commit();
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
	}

	@Override
	public Employment readEmployment(int id) {
		DataAccess dataAccess = null;
		crudEmploymentMapper = new CrudEmploymentMapper();
		Employment employment = null;
		try {
			dataAccess = new DataAccessImpl();
			employment = crudEmploymentMapper.read(dataAccess, id);
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
		return employment;
	}

	@Override
	public void updateEmployment(Employment employment) {
		DataAccess dataAccess = null;
		crudEmploymentMapper = new CrudEmploymentMapper();
		try {
			dataAccess = new DataAccessImpl();
			crudEmploymentMapper.update(dataAccess, employment);
			dataAccess.commit();
		} catch (Exception exc) {
			dataAccess.rollback();
		} finally {
			dataAccess.close();
		}
	}

}
