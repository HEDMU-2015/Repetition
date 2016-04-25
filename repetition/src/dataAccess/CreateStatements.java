package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatements {
DataAccessForSQL dasql = new DataAccessForSQL();

public static String CREATE_PERSON = "CREATE TABLE Person"
		+ "(id bigint IDENTITY,"
		+ "name varchar(80) NOT NULL"
		+ ",birthdate date NOT NULL,)";
public static String CREATE_EMPLOYMENT = "CREATE TABLE Employment"
		+ "(id bigint IDENTITY NOT NULL,"
		+ "company varchar(50) NOT NULL,"
		+ "employmentdate date NOT NULL,"
		+ "FOREIGN KEY (id) REFERENCES Person(id),)";

	

public void createPerson() throws SQLException{
	
		Connection con = dasql.getConnection();
		PreparedStatement statement = null;
		statement =  con.prepareStatement(CREATE_PERSON);
		statement.executeUpdate();
		
		con.close();
		
	}

public void createEmployement() throws SQLException{
	
	Connection con = dasql.getConnection();
	PreparedStatement statement = null;
	statement =  con.prepareStatement(CREATE_EMPLOYMENT);
	statement.executeUpdate();
	
	con.close();
	
}
}
