package repetition;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataAccess.DataAccess;
import dataAccess.DataAccessForSQL;

public class CrudPerson {
	public static String CREATE_PERSON = "INSERT INTO PERSON (ID,name, birthdate) VALUES (null,?,? )";
	public static String READ_PERSON = "SELECT * FROM PERSON";
	public static String UPDATE_PERSON ="UPDATE person SET name=?,birthdate=? WHERE ID=?";
	public static String DELETE_PERSON="DELETE FROM person WHERE ID=?";
	
	
	public void create(DataAccessForSQL da, Person person) throws SQLException {
		try {
			Connection con = da.getConnection();
			PreparedStatement pst = con.prepareStatement(CREATE_PERSON);
			pst.setString(1, person.getName());
			pst.setDate(2, Date.valueOf(person.getBirthdate()));
			pst.executeUpdate();
			con.commit();
			pst.close();
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Person> read(DataAccessForSQL da) throws SQLException {
		Connection con = da.getConnection();
		PreparedStatement pst = con.prepareStatement(READ_PERSON);
		ResultSet resultset = pst.executeQuery();
		ArrayList<Person> persons = new ArrayList();

		while (resultset.next()) {
			Person p = new Person();
			p.setName(resultset.getString("name"));

			p.setID(resultset.getInt("ID"));
			p.setBirthdate(resultset.getDate("birthdate").toLocalDate());
			persons.add(p);
		}

		return persons;

	}
	
	public void update(DataAccessForSQL da,Person person){
		try {
			Connection con = da.getConnection();
			PreparedStatement pst = con.prepareStatement(UPDATE_PERSON);
			
			pst.setString(1, person.getName());
			pst.setDate(2, Date.valueOf(person.getBirthdate()));
			pst.setInt(3, person.getID());
			pst.executeUpdate();
			con.commit();
			pst.close();
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(DataAccessForSQL da,Person person){
		try {
			Connection con = da.getConnection();
			PreparedStatement pst = con.prepareStatement(DELETE_PERSON);
			pst.setInt(1, person.getID());
			pst.executeUpdate();
			con.commit();
			pst.close();
			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
