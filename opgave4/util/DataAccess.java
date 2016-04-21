package util;

import java.sql.Connection;


public class DataAccess {
	private Connection connection = null;

	public DataAccess(){
		
		this.connection = ConnectionHandler.instance().getConnection();
	}

	public Connection getConnection() {
		return this.connection;
	}

	
	public void commit()  {
		ConnectionHandler.instance().commit();

	}

	
	public void close() {
		ConnectionHandler.instance().close();
	}

	
	public void rollback() {
		ConnectionHandler.instance().rollback();
	}

}
