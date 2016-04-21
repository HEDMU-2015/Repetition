package persistence;

import exception.PersistenceFailureException;

public interface Crud<D, K> {

	public void create(DataAccess dataAccess, D domain) throws PersistenceFailureException;

	public D read(DataAccess dataAccess, K key) throws PersistenceFailureException;

	public void update(DataAccess dataAccess, D domain) throws PersistenceFailureException;

	public void delete(DataAccess dataAccess, D domain) throws PersistenceFailureException;

}
