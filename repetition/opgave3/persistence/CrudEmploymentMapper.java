package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Employment;
import exception.PersistenceFailureException;

public class CrudEmploymentMapper implements Crud<Employment, Integer> {

	private final static String CREATE_EMPLOYMENT = "INSERT INTO employment(company, employmentdate, personid) VALUES(?, ?, ?)";
	private final static String READ_EMPLOYMENT = "SELECT * FROM employment WHERE id = ?";
	private final static String UPDATE_EMPLOYMENT = "UPDATE employment SET name = ? WHERE id = ?";
	private final static String DELETE_EMPLOYMENT = "DELETE FROM employment WHERE id = ?";

	@Override
	public void create(DataAccess dataAccess, Employment employment) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(CREATE_EMPLOYMENT);
			statement.setString(1, employment.getCompany());
			statement.setDate(2, Date.valueOf(employment.getEmploymentDate()));
			statement.setInt(3, employment.getPersonId());
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
	public Employment read(DataAccess dataAccess, Integer id) throws PersistenceFailureException {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(READ_EMPLOYMENT);
			Employment employement = new Employment();
			statement.setInt(1, employement.getId());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				employement.setId(resultSet.getInt("id"));
				employement.setCompany(resultSet.getString("company"));
			}
			return employement;
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
	public void update(DataAccess dataAccess, Employment employment) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(UPDATE_EMPLOYMENT);
			statement.setString(1, employment.getCompany());
			statement.setInt(2, employment.getId());
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
	public void delete(DataAccess dataAccess, Employment employment) throws PersistenceFailureException {
		PreparedStatement statement = null;
		try {
			statement = dataAccess.getConnection().prepareStatement(DELETE_EMPLOYMENT);
			statement.setInt(1, employment.getId());
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
