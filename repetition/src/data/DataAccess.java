package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAccess { 
	private static final String CONNECTION_URL = "jdbc:hsqldb:hsql://localhost/mydatabase";
	private static final String DB_USER = "SA";
	private static final String DB_PASSWORD = "";
	private Connection connection = null;

	public DataAccess() { 
		try {
			this.connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}
	}

	public Connection getConnection(){ 
		try {
			PreparedStatement create = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS Person( id bigint IDENTITY(start with 1), name varchar(80) NOT NULL, email varchar(255)UNIQUE, birthdate DATE NOT NULL");
			create.executeUpdate();
			
			PreparedStatement create2 = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS Employment(id IDENTITY,company varchar(255) NOT NULL, employmentdate Date NOT NULL, person FOREIGN KEY");
			create2.executeUpdate();
			
			
		} catch (Exception e) {
			throw new RuntimeException ("Create DB Failed", e);
		} finally {
		}		
		return this.connection;
	}	


	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}
	}

	public void commit() {
		try {
			this.connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}
	}

	public void rollback() {
		try {
			this.connection.rollback();
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not available.", e);
		}
	}

}