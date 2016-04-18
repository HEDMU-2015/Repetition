package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.PersistenceCommitFailureException;
import exception.PersistenceConnectionFailureException;

public class DataAccessImpl implements DataAccess {

	private Connection connection = null;

	public DataAccessImpl() throws PersistenceConnectionFailureException {
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
		} catch (SQLException exc) {
			throw new PersistenceConnectionFailureException("Failed to connect to database");
		}
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public void commit() throws PersistenceCommitFailureException {
		if (connection != null) {
			try {
				connection.commit();
			} catch (SQLException exc) {
				throw new PersistenceCommitFailureException("Failed to commit transaction");
			}
		}
	}

	@Override
	public void rollback() {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException exc) {
			}
		}
	}

	@Override
	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException exc) {
			}
		}
	}

}
