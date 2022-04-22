package commonLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains genric methods of databse
 * @author VIVEK
 *
 */

public class DataBaseLibrary 
{
	Connection con;
	// create the driver ref
	// register to db
	// get the conncetion
	// issue create statement
	// execute the query
	// close the db
	
	/**
	 * This method will establish the conncetion to DB
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
	    con = DriverManager.getConnection(ConstantsLibrary.dbURL, ConstantsLibrary.dbUsername, ConstantsLibrary.dbPassword);
	    
	    
	}
	
	
	/**
	 * This method will close the DB conncetion
	 * @throws Throwable
	 */
	public void closeDb() throws Throwable
	{
		con.close();
	}
	/**
	 * This method will check the database for expdata and and return
	 * if the expData mataches actual data
	 * @param query
	 * @param column
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	
	public String executeQueryAndGetData(String query, int column,String expData) throws Throwable
	{
		String data;
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data=result.getString(column).toString();
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
			}
		}
		if(flag)
		{
			System.out.println(expData+"data vrified");
			return expData;
		}
		else
		{
			System.out.println("data not verified");
			return "";
		}
	}
	

}
