package MainClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Class Writer: Mark Melling
 * Instructor: Paul Corey & Helena Gibson
 * Description: Name Class
 * Date: 27/02/2016
 * @author Mark Melling
 * @version 4.0
**/

public class Fixture
{
	private int fixtureID; //Unique identifier for the fixture
	private int firstTeamID, secondTeamID; //The teams playing
	private int refereeID; //The referee assigned to the fixture
	private int venueID; //The venue assigned to the fixture
	private Date date; //The date of the fixture
	private String time; //The time of the fixture..This is a String to simplify entry, but it can be changed
	
	//sql and database variables
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "SportManagement?useSSL=false";
	@SuppressWarnings("unused")
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String password = "password";
	private Statement statement = null;   
	private ResultSet resultSet = null;
	
	
	//Default constructor
	public Fixture()
	{
		fixtureID = -1;
		firstTeamID = -1; //The IDs are -1 to prevent accidentally assigning a team or referee
		secondTeamID = -1;
		refereeID = -1;
		venueID = -1;
		date = new Date();
		time = null;
	}
	
	//Initialized constructor
	public Fixture(int fixtureID, int day, int month, int year, int venueID, int firstTeamID, int secondTeamID, int refereeID)
	{
		this.fixtureID = fixtureID;
		this.firstTeamID = firstTeamID;
		this.secondTeamID = secondTeamID;
		this.refereeID = refereeID;
		this.venueID = venueID;
		date = new Date(day, month, year);
		//this.time = time;
	}
	
	//GETTERS AND SETTERS
	
	public int getFirstTeamID()
	{
		return firstTeamID;
	}
	
	public void setFirstTeamID(int ID)
	{
		firstTeamID = ID;
	}
	
	public int getSecondTeamID()
	{
		return secondTeamID;
	}
	
	public void setSecondTeamID(int ID)
	{
		secondTeamID = ID;
	}
	
	public int getRefereeID()
	{
		return refereeID;
	}
	
	public void setRefereeID(int ID)
	{
		refereeID = ID;
	}
	
	public int getVenueID()
	{
		return venueID;
	}
	
	public void setvenueID(int ID)
	{
		venueID = ID;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(int day, int month, int year)
	{
		date = new Date(day, month, year);
	}
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	
	public int getFixtureID()
	{
		return fixtureID;
	}
	
	//Returns information about the Fixture object
	public String toString()
	{
		//NOTE: This can't be implemented until the various IDs search for the correct teams, referee, and venue
		return null;
	}
	
	 
	///////////////////////////////////////////////////////
	// Method Name : add()								 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads one Venue record from the user    //
	//           and adds it to the ArrayList Fitures    //
	///////////////////////////////////////////////////////	 
	 
	public int add(Fixture fIn)   
	{ 
	   int status=0;
	    
	   String sqlString = "insert into sportManagement.fixture(fixtureID, fixtureDate, venue, teamOne, teamTwo, referee) values(" + fIn.getFixtureID()
	    					+ ",\"" + fIn.date.toString() + "\"," + fIn.getVenueID() + "," + fIn.getFirstTeamID() + "," + fIn.getSecondTeamID()
	    					+ "," + fIn.getRefereeID() +")";
	   System.out.println(sqlString);
	   status = databaseUpdate(sqlString);
	   return status;
	}
	
	
	///////////////////////////////////////////////////////
	// Method Name : list()							     //
	// Return Type : void					   		     //
	// Parameters : None								 //
	// Purpose : Lists all Fitures records in fixture    //
	///////////////////////////////////////////////////////
	
	public void getAllFixtures()      
	{ 
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url+dbName,userName,password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from sportManagement.fixture");
	
			while ( resultSet.next() )    
			{
				System.out.println("\n\nFixture ID: " + resultSet.getInt("fixtureId") + "\nFixture Date: " + resultSet.getString("fixtureDate")
									+ "\nVenue ID: " + resultSet.getInt("venue") + "\nFirst Team ID: " + resultSet.getInt("teamOne")
									+ "\nSecond Team ID: " + resultSet.getInt("teamTwo") + "\nReferee ID: " + resultSet.getInt("referee"));                
			}
			conn.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}    
	} 
	 
	
	///////////////////////////////////////////////////////////////
	// Method Name : view()									     //
	// Return Type : void									     //
	// Parameters : None									 	 //
	// Purpose : Displays the required Fixture record on screen  //
	///////////////////////////////////////////////////////////////	 
		
	public void getFixture(int searchNo)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from sportManagement.fixture where sportManagement.fixture.fixtureID = " + searchNo);
		
			while ( resultSet.next() )      
			{
				System.out.println("\n\nFixture ID: " + resultSet.getInt("fixtureId") + "\nFixture Date: " + resultSet.getString("fixtureDate")
									+ "\nVenue ID: " + resultSet.getInt("venue") + "\nFirst Team ID: " + resultSet.getInt("teamOne")
									+ "\nSecond Team ID: " + resultSet.getInt("teamTwo") + "\nReferee ID: " + resultSet.getInt("referee")); 
			}   
			conn.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	///////////////////////////////////////////////////////////////////
	// Method Name : delete()									     //
	// Return Type : void										     //
	// Parameters : None									 	     //
	// Purpose : Deletes the required Venue record from venue        //
	///////////////////////////////////////////////////////////////////	

	public int delete(int fixtureNoIn)   
	{
	   int status = 0; 
	    
	   String sqlString = "delete from sportManagement.fixture where fixtureID = " + fixtureNoIn;     
	   status = databaseUpdate(sqlString);                                        
	   return status;
	}
	
	
	///////////////////////////////////////////////////////////////
	// Method Name : edit()									     //
	// Return Type : void										 //
	// Parameters : None									 	 //
	// Purpose : Edits the required Venue record in venue        //
	///////////////////////////////////////////////////////////////		
	 
	public int edit(int changeNo, int day, int month, int year, int venueID, int firstTeamID, int secondTeamID, int refereeID)   
	{
		int status = 0;
	    String sqlString = "update sportManagement.fixture set fixtureDate = " + "\"" + day + "/" + month + "/" + year
	    		  		   	+ "\", venue = " + venueID + ", teamOne = " + firstTeamID + ", teamTwo = "
	    		  		   	+ secondTeamID + ", referee = " + refereeID + " where fixtureID = " + changeNo;
	    System.out.println(sqlString);
	    status = databaseUpdate(sqlString);                                           
	               
	    return status;
	}
	 
	 
	///////////////////////////////////////////////////////////////
	// Purpose : Connection to database					   	     //
	// 									                         //
	///////////////////////////////////////////////////////////////
	 
	private int databaseUpdate(String sqlUpdate)
	{
		int status=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			status = statement.executeUpdate(sqlUpdate);
			conn.close(); 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}   
		return status;
	}
}




