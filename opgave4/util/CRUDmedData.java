package util;

import java.util.Optional;

import domain.Person;

/**
 * 
 * @author Juyoung Choi
 *
 * @param <D>
 * @param <K>
 */
public interface CRUDmedData<D, K> {
		
	public void create(DataAccess dataAccess, D domain);

	public Optional<Person> read (DataAccess dataAccess, K key);
	
	public void update(DataAccess dataAccess, D domain);
	
	public void delete(DataAccess dataAccess, K key);
		
}
