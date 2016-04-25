package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccessForSQL {
	
	protected Connection connection = null;

	public DataAccessForSQL() {
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException("No connection to the database", e);
		}
		
	}
	
	/**
	 * Denne metode retunerer instans af Connection eller null.
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Exception caught", e);
			}	
		}
	}
	
	public void commit() {
		if (connection != null) {
			try {
				connection.commit();
			} catch (SQLException e) {
				throw new RuntimeException("Exception caught", e);
			}	
		}
	}

	public void rollback() {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}

	}

	public void setSavepoint(String name) {
		if (connection != null) {
			try {
				connection.setSavepoint(name);
			} catch (SQLException e) {
				throw new RuntimeException("Exception caught", e);
			}
		}
	}

}
