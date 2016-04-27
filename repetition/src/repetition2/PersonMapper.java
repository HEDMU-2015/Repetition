package repetition2;

import java.sql.PreparedStatement;

import exceptions.PersistenceCommitFailureException;

public class PersonMapper {

	private final String CREATE_PERSON = "INSERT INTO Person (name, email, birthdate) VALUES ('?', '?', '?')";
	private final String READ_PERSON = "SELECT * FROM Person WHERE id = ?";
	private final String UPDATE_PERSON = "UPDATE Person SET name = ?, email = ?, birthdate = ? WHERE id = ?";
	private final String DELETE_PERSON = "DELETE * FROM Person WHERE id = ?";
	
	public PersonMapper() {
		
	}
	
	public void createPerson(Person person, DataAccess da) throws PersistenceCommitFailureException {
		PreparedStatement statement;
		
	}
	
	public Person readPerson(Person person, DataAccess da) {
		return null;
	}
	
	public void updatePerson(Person person, DataAccess da) throws PersistenceCommitFailureException {
		
	}
	
	public void deletePerson(Person person, DataAccess da) throws PersistenceCommitFailureException {
		
	}
}
