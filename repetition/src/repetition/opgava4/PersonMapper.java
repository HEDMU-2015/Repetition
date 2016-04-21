package repetition.opgava4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Date;




public class PersonMapper implements CRUDmedData<Person, String> {
	private CloseForSQL close = new CloseForSQL();
	private final static String CREATE_PERSON = "INSERT INTO person(name, email, birthday) VALUES(?,?,?)";
	private final static String READ_PERSON = "SELECT * FROM person WHERE email = ?";
	private final static String UPDATE_PERSON = "UPDATE person SET name = ? , email = ? , birthday = ? WHERE id = ?";
	private final static String DELETE_PERSON = "DELETE FROM person WHERE email = ?";
	private final static String LIST_PERSON = "SELECT * FROM person";

	
	public List<Person> getList(DataAccess dataAccess){
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Person> personList = new ArrayList<>();
		
		try {
			statement = dataAccess.getConnection().prepareStatement(LIST_PERSON);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				Person person1 = new Person.Builder
						(resultSet.getString("name"), 
								resultSet.getString("email"), 
								new java.sql.Date(resultSet.getDate("birthday").getTime()).toLocalDate()).build();
				personList.add(person1);
			}

		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);

		} finally {
			close.close(resultSet, statement);
		}	
		return personList;
		
		
	}

	@Override
	public void create(DataAccess dataAccess, Person domain) {

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
	public Optional<Person> read(DataAccess dataAccess, String key) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Optional<Person> person = Optional.empty();
		try {
			statement = dataAccess.getConnection().prepareStatement(READ_PERSON);
			statement.setString(1, key);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				Person person1 = new Person.Builder
						(resultSet.getString("name"), 
								resultSet.getString("email"), 
								new java.sql.Date(resultSet.getDate("birthday").getTime()).toLocalDate()).build();
				
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
	public void update(DataAccess dataAccess, Person domain) {
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
	public void delete(DataAccess dataAccess, String key) {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(DELETE_PERSON);			
			statement.setString(1, key);
			statement.execute();
		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);
		} finally {
			close.close(statement);
		}		
	}
}
