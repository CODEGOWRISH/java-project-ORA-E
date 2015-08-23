/**
 * 
 */
package gow.ora.conn;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 * @author dbgsm0
 *
 */
public class DbConn {

	OracleDataSource 	ds;
	Connection			connection;
	
	public Connection getDBConnJDBCThin (
			String 	username,
			String 	password,
			String	hostOrScanName,
			String 	port,
			String	serviceNameOrSID
			) 
			throws SQLException {
	
		ds = new OracleDataSource();
		
		try {
			// This is URL that works with service-name
			//jdbc:oracle:thin:scott/tiger@//myhost:1521/myservicename
			String jdbcURL = "jdbc:oracle:thin:" + username + "/" + password + "@//" + hostOrScanName + ":" 
													+ port + "/" + serviceNameOrSID;
			
			ds.setURL(jdbcURL);
			connection = ds.getConnection();
			
			System.out.println ("INFO - Connected using Service Name");
			
			return connection;
		}
		catch (SQLException e) {
			
			System.out.println ("INFO - Could not connect using Service Name, trying as SID");
			
			// This is URL that works for SID
			// jdbc:oracle:thin:@oracle.hostserver1.mydomain.ca:1521:XYZ
			String jdbcURL = "jdbc:oracle:thin:@" + hostOrScanName + ":" + port + ":" + serviceNameOrSID;  
			
			ds.setURL(jdbcURL);
			connection = ds.getConnection(username, password);
			
			System.out.println ("INFO - Connected using SID");
			
			return connection;
		}

	} // getDBConnJDBCThin method

} // GetDBConn class
