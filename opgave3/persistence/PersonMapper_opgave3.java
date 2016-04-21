package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import domain.Person_opgave3;
import util.CRUD_opgave3;
import util.CloseForSQL_opgave3;
import util.DataAccess_opgave3;

import java.sql.Date;




public class PersonMapper_opgave3 implements CRUD_opgave3<Person_opgave3, Integer> {
	private CloseForSQL_opgave3 close = new CloseForSQL_opgave3();
	private final static String CREATE_PERSON = "INSERT INTO person(name, email, birthday) VALUES(?,?,?)";
	private final static String READ_PERSON = "SELECT * FROM person WHERE id = ?";
	private final static String UPDATE_PERSON = "UPDATE person SET name = ? , email = ? , birthday = ? WHERE id = ?";
	private final static String DELETE_PERSON = "DELETE FROM person WHERE id = ?";


	@Override
	public void create(DataAccess_opgave3 dataAccess, Person_opgave3 domain) {

		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(CREATE_PERSON);
			statement.setString(1, domain.getName());
			statement.setString(2, domain.getEmail());
			statement.setDate(3, Date.valueOf(domain.getBirthday()));

			statement.execute();
		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);
		} finally {
			close.close(statement);
		}		
	}

	@Override
	public Optional<Person_opgave3> read(DataAccess_opgave3 dataAccess, Integer key) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Optional<Person_opgave3> person = Optional.empty();
		try {
			statement = dataAccess.getConnection().prepareStatement(READ_PERSON);
			statement.setInt(1, key);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				Person_opgave3 person1 = new Person_opgave3();
				person1.setId(resultSet.getInt("id"));
				person1.setName(resultSet.getString("name"));
				person1.setEmail(resultSet.getString("email"));
				person1.setBirthday(new java.sql.Date(resultSet.getDate("birthday").getTime()).toLocalDate());
				person = Optional.of(person1);
			}

		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);

		} finally {
			close.close(resultSet, statement);
		}	
		return person;
	}

	@Override
	public void update(DataAccess_opgave3 dataAccess, Person_opgave3 domain) {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(UPDATE_PERSON);
			statement.setString(1, domain.getName());
			statement.setString(2, domain.getEmail());
			statement.setDate(3, Date.valueOf(domain.getBirthday()));
			statement.setInt(4, domain.getId());
			statement.execute();
		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);
		} finally {
			close.close(statement);
		}		
	}

	@Override
	public void delete(DataAccess_opgave3 dataAccess, Person_opgave3 domain) {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(DELETE_PERSON);			
			statement.setInt(1, domain.getId());
			statement.execute();
		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);
		} finally {
			close.close(statement);
		}		
	}
}
