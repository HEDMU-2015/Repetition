package dataAccess;

import java.sql.Connection;



public interface DataAccess {

	public Connection getConnection();
	public void commit(); 
	public void rollback();
	public void close();	
	public void setAutoCommit(boolean bool);
	
}
