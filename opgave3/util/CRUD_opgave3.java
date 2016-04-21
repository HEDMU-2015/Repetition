package util;

import java.util.Optional;


public interface CRUD_opgave3<D, K> {
		
	public void create(DataAccess_opgave3 dataAccess, D domain);

	public Optional<D> read (DataAccess_opgave3 dataAccess, K key);
	
	public void update (DataAccess_opgave3 dataAccess,D domain);
	
	public void delete (DataAccess_opgave3 dataAccess,D domain);
		
}
