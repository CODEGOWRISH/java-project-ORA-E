package gow.ora.dh;

import java.sql.Connection;
import java.sql.SQLException;

import gow.ora.conn.*;


public class TestJDBCThinConn {

	public static void main(String[] args) {

		System.out.println ("INFO - Entering");
		
		int argCount = args.length;
		
		
		if (argCount < 5) {
			System.out.println ("ERR- Insufficient Arguments.  Need username, password, hostOrScanName,"
					+ " port, serviceName");
		}
		
		String 	username = args[0];
		String 	password = args[1];
		String	hostOrScanName = args[2];
		String 	port = args[3];
		String	serviceName = args[4];
		
		try
		{
			Connection connection = new DbConn().getDBConnJDBCThin (username, password, hostOrScanName, port, serviceName);
			
			//DBConn dbConnClass = new DbConn();
			//Connection connection = dbConnClass.getDBConnJDBCThin (username, password, hostOrScanName, port, serviceName);
		}
			catch (SQLException e)
			{
				// you handle the exception here
					e.printStackTrace();
			}
		
		System.out.println ("INFO - Exiting");
	}

}
