package repetition.opgave3;

import java.util.Optional;


public interface CRUD<D, K> {
		
	public void create(DataAccess dataAccess, D domain);

	public Optional<D> read (DataAccess dataAccess, K key);
	
	public void update (DataAccess dataAccess,D domain);
	
	public void delete (DataAccess dataAccess,D domain);
		
}
