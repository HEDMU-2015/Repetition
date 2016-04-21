package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Person;
import exception.PersistenceFailureException;

public class CrudPersonMapper implements Crud<Person, Integer> {

	private final static String CREATE_PERSON = "INSERT INTO person(name, birthday) VALUES(?, ?)";
	private final static String READ_PERSON = "SELECT * FROM person WHERE id = ?";
	private final static String UPDATE_PERSON = "UPDATE person SET name = ? WHERE id = ?";
	private final static String DELETE_PERSON = "DELETE FROM person WHERE id = ?";

	@Override
	public void create(DataAccess dataAccess, Person person) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(CREATE_PERSON);
			statement.setString(1, person.getName());
			statement.setDate(2, Date.valueOf(person.getBirthday()));
			statement.execute();
		} catch (SQLException exc) {
			throw new PersistenceFailureException("Query has failed!");
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public Person read(DataAccess dataAccess, Integer id) throws PersistenceFailureException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(READ_PERSON);
			Person person = new Person();
			statement.setInt(1, person.getId());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				person.setId(resultSet.getInt("id"));
				person.setName(resultSet.getString("name"));
			}
			return person;
		} catch (SQLException e) {
			throw new PersistenceFailureException("Query has failed!");
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void update(DataAccess dataAccess, Person person) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(UPDATE_PERSON);
			statement.setString(1, person.getName());
			statement.setInt(2, person.getId());
			statement.execute();
		} catch (SQLException exc) {
			throw new PersistenceFailureException("Query has failed");
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void delete(DataAccess dataAccess, Person person) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(DELETE_PERSON);
			statement.setInt(1, person.getId());
			statement.execute();
		} catch (SQLException exc) {
			throw new PersistenceFailureException("Query has failed!");
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
