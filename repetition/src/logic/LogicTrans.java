package logic;

import java.util.function.Supplier;

import data.DataAccess;

public class LogicTrans<T> {
	
	DataAccess dataaccess = null;
	
	public LogicTrans(DataAccess dataccess) {
		this.dataaccess = dataccess;
	}

	public T transaction(Supplier<T> supplier) {
		try {
			T t = supplier.get();
			dataaccess.commit();
			return t;
		} catch (Exception e) {
			dataaccess.rollback();
			throw new RuntimeException("Transaction rolled back", e);
		} finally {
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
