package gow.ora.dh;

import java.sql.*;

public class DataHandler {
	

	public ResultSet queryResultSet (Connection connection, String query) throws SQLException {
		
		Statement 	statement = connection.createStatement();
		ResultSet	resultSet = statement.executeQuery(query);
		
		return resultSet;
	}

}
