package repetition2;

import java.sql.Connection;

import exceptions.PersistenceCommitFailureException;

public interface DataAccess {

	public Connection getConnection();
	public void commit() throws PersistenceCommitFailureException;
	public void rollback();
	public void close();	
	public void setAutoCommit(boolean bool);
	
}
