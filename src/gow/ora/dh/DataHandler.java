package gow.ora.dh;

import gow.ora.conn.DbConn;

import java.sql.*;

public class DataHandler {

	public ResultSet queryResultSet(Connection connection, String query)
			throws SQLException {

		Statement statement = connection.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery(query);
		resultSet.beforeFirst();

		return resultSet;
	}

	public ResultSet queryResultSet(String username, String password,
			String hostOrScanName, String port, String serviceNameOrSID,
			String query) throws SQLException {

		// For debug only
		// String jdbcURL = "jdbc:oracle:thin:" + username + "/" + password +
		// "@//" + hostOrScanName + ":" + port + "/" + serviceNameOrSID;
		// System.out.println ("INFO - jdbcURL in DataHandler is - " + jdbcURL);

		Connection connection = new DbConn().getDBConnJDBCThin(username,
				password, hostOrScanName, port, serviceNameOrSID);

		Statement statement = connection.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery(query);
		resultSet.beforeFirst();

		return resultSet;
	}

}
