package util;

import java.sql.Connection;


public class DataAccess_opgave3 {
	private Connection connection = null;

	public DataAccess_opgave3(){
		
		this.connection = ConnectionHandler_opgave3.instance().getConnection();
	}

	public Connection getConnection() {
		return this.connection;
	}

	
	public void commit()  {
		ConnectionHandler_opgave3.instance().commit();

	}

	
	public void close() {
		ConnectionHandler_opgave3.instance().close();
	}

	
	public void rollback() {
		ConnectionHandler_opgave3.instance().rollback();
	}

}
