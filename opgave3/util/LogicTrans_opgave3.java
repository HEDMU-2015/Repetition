package util;

import java.util.function.Supplier;


public class LogicTrans_opgave3<T> {
DataAccess_opgave3 dataaccess = null;
	
	public LogicTrans_opgave3(DataAccess_opgave3 dataccess) {
		this.dataaccess = dataccess;
	}

	public T transaction (Supplier<T> supplier) {
		try {
			T t = supplier.get();
			dataaccess.commit();

			return t;
		} catch (Exception e) {
			dataaccess.rollback();
			throw new RuntimeException("Transaction rolled back", e);
		} finally {
			if(dataaccess != null)
				dataaccess.close();			
		}
	}

	
	
	public void transaction(Runnable runnable) { 
		try {
			runnable.run();
			dataaccess.commit();
		} catch (Exception e) {
			dataaccess.rollback();
			throw new RuntimeException("Transaction rolled back", e);
		} finally {
			dataaccess.close();			
		}
	}
}
