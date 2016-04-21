package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.PersonBuilder;
import exception.PersistenceFailureException;

public class CrudPersonMapper2 implements Crud2<PersonBuilder, String> {

	private final static String CREATE_PERSON = "INSERT INTO person(name, birthday) VALUES(?, ?)";
	private final static String READ_PERSON = "SELECT * FROM person WHERE id = ?";
	private final static String UPDATE_PERSON = "UPDATE person SET name = ? WHERE id = ?";
	private final static String DELETE_PERSON = "DELETE FROM person WHERE id = ?";
	private final static String FETCH_ALL_PERSONS = "SELECT * FROM person";

	@Override
	public void create(DataAccess dataAccess, PersonBuilder person) throws PersistenceFailureException {
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
	public PersonBuilder read(DataAccess dataAccess, String id) throws PersistenceFailureException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PersonBuilder personBuilder = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(READ_PERSON);
			statement.setString(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				personBuilder = new PersonBuilder.Builder(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getDate("birthday").toLocalDate()).build();
			}
			return personBuilder;
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
	public void update(DataAccess dataAccess, PersonBuilder person) throws PersistenceFailureException {
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
	public void delete(DataAccess dataAccess, PersonBuilder person) throws PersistenceFailureException {
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

	@Override
	public List<PersonBuilder> persons(DataAccess dataAccess) throws PersistenceFailureException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<PersonBuilder> persons = new ArrayList<>();
		try {
			statement = dataAccess.getConnection().prepareStatement(FETCH_ALL_PERSONS);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				PersonBuilder personBuilder = new PersonBuilder.Builder(resultSet.getInt("id"),
						resultSet.getString("name"), resultSet.getDate("birthday").toLocalDate()).build();
				persons.add(personBuilder);
			}
			return persons;
		} catch (SQLException exc) {
			throw new PersistenceFailureException("Query has failed");
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

}
