package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import domain.Employment_opgave3;
import domain.Person_opgave3;
import util.CRUD_opgave3;
import util.CloseForSQL_opgave3;
import util.DataAccess_opgave3;

public class EmploymentMapper_opgave3 implements CRUD_opgave3<Employment_opgave3, Integer> {
	private CloseForSQL_opgave3 close = new CloseForSQL_opgave3();
	private final static String CREATE_EMPLOYMENT = "INSERT INTO employment(company, employment, person) VALUES(?,?,?)";
	private final static String READ_EMPLOYMENT = "SELECT id, company, employment, person as personID, person.name, "
			+ "person.email, person.birthday "
			+ "FROM employment inner join person on  person = person.id WHERE id = ?";
	private final static String UPDATE_EMPLOYMENT = "UPDATE employemnt SET company = ? , employment = ? , person = ? WHERE id = ?";
	private final static String DELETE_EMPLOYMENT = "DELETE FROM employment WHERE id = ?";

	@Override
	public void create(DataAccess_opgave3 dataAccess, Employment_opgave3 domain) {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(CREATE_EMPLOYMENT);
			statement.setString(1, domain.getCompany());
			statement.setDate(2, Date.valueOf(domain.getEmployment()));
			statement.setInt(3, domain.getPerson().getId());

			statement.execute();
		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);
		} finally {
			close.close(statement);
		}				
	}

	@Override
	public Optional<Employment_opgave3> read(DataAccess_opgave3 dataAccess, Integer key) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Optional<Employment_opgave3> employment = Optional.empty();
		try {
			statement = dataAccess.getConnection().prepareStatement(READ_EMPLOYMENT);
			statement.setInt(1, key);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				Employment_opgave3 employemnt1 = new Employment_opgave3();
				employemnt1.setCompany(resultSet.getString("company"));
				employemnt1.setEmployment(new java.sql.Date(resultSet.getDate("employment").getTime()).toLocalDate());
				employemnt1.setPerson(new Person_opgave3(resultSet.getString("name"), 
						resultSet.getString(resultSet.getString("email")), 
						new java.sql.Date(resultSet.getDate("birthday").getTime()).toLocalDate()));
				employment = Optional.of(employemnt1);
			}

		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);

		} finally {
			close.close(resultSet, statement);
		}	
		return employment;
	}

	@Override
	public void update(DataAccess_opgave3 dataAccess, Employment_opgave3 domain) {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(UPDATE_EMPLOYMENT);
			statement.setString(1, domain.getCompany());
			statement.setDate(2,  Date.valueOf(domain.getEmployment()));
			statement.setInt(3, domain.getPerson().getId());
			statement.setInt(4, domain.getId());
			statement.execute();
		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);
		} finally {
			close.close(statement);
		}				
	}

	@Override
	public void delete(DataAccess_opgave3 dataAccess, Employment_opgave3 domain) {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(DELETE_EMPLOYMENT);			
			statement.setInt(1, domain.getId());
			statement.execute();
		} catch (SQLException exc) {
			throw new RuntimeException("Query has failed!" , exc);
		} finally {
			close.close(statement);
		}		
	}
}
