package util;
/**
 * 
 * @author Juyoung Choi
 *
 * @param <D>
 * @param <K>
 */
public interface CRUD<D, K> {
		
	public void create(D domain);

	public D read (K key);
	
	public void update(D domain);
	
	public void delete(D domain);
		
}
