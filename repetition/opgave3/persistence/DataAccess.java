package persistence;

import java.sql.Connection;

import exception.PersistenceCommitFailureException;

public interface DataAccess {

	public Connection getConnection();

	public void commit() throws PersistenceCommitFailureException;

	public void rollback();

	public void close();

}
