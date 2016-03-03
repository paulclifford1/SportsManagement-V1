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

public class Venue 
{
	private String venueName;	//Venue name
	private String location;	//Venue address
	private int venueID;		//Unique identifier for the venue
	
	//SQL & Database Variables
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "SportManagement?useSSL=false";
	@SuppressWarnings("unused")
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String password = "password";
	private Statement statement = null;   
	private ResultSet resultSet = null;
	
	
	
	//Default Constructor
	public Venue()
	{
		venueName = null;
		location = null;
	}
	
	//Initialized Constructor
	public Venue(int venueID, String venueName, String location)
	{
		this.venueID = venueID;
		this.venueName = venueName;
		this.location = location;
	}
	
	//Getters AND Setters
	public String getName()
	{
		return venueName;
	}
	
	public void setName(String venueName)
	{
		this.venueName = venueName;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	
	public int getVenueID()
	{
		return venueID;
	}
	
	//Returns information about the venue object
	public String toString()
	{
		return "  " + venueID + "\t\t " + venueName + "\t\t" + location + "\n";
	}
	
	
	///////////////////////////////////////////////////////
	// Method Name : add()								 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads one Venue record from the user    //
	//           and adds it to the ArrayList Venues     //
	///////////////////////////////////////////////////////	
	
	public int add(Venue vIn)   
	{ 
		int status=0;
	    
		String sqlString = "insert into sportmanagement.venue(venueID, venueName, location) values("+
						   vIn.getVenueID() + ",\"" + vIn.getName() + "\"," + "\"" + vIn.getLocation() + "\""+ ")";
		
		                                                        //  ",\'"+ sIn.getSKillDate()+ "\'"+ ")"; String
															    //              + tIn.getNoOfPlayers() +")"; int
	    System.out.println(sqlString);
	    status = databaseUpdate(sqlString);
	    return status;
	}  

	
	///////////////////////////////////////////////////////
	// Method Name : list()								 //
	// Return Type : void					   		     //
	// Parameters : None								 //
	// Purpose : Lists all Venues records in venue       //
	///////////////////////////////////////////////////////
	
	public void getAllVenues()      
	{ 
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(url + dbName, userName, password);
		    statement = conn.createStatement();
		    resultSet = statement.executeQuery("select * from SportManagement.venue");
		       
		    while (resultSet.next() )    
		    {
		    	System.out.println("Venue ID: " + resultSet.getInt("venueID") + ", Venue Name: " + resultSet.getString("venueName")
		    	+", Location: " + resultSet.getString("location"));
		    }
		    conn.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}    
	} 
		
	
	///////////////////////////////////////////////////////////////
	// Method Name : view()										 //
	// Return Type : void										 //
	// Parameters : None									 	 //
	// Purpose : Displays the required Venue record on screen    //
	///////////////////////////////////////////////////////////////	 
	
	public void getVenue(int searchNo)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from SportManagement.venue where SportManagement.venue.venueID = " + searchNo);
		                 
			while ( resultSet.next() )      
			{
				System.out.println("Venue ID: " + resultSet.getInt("venueID") + ", Venue Name: " + resultSet.getString("venueName")
	                         		+", Venue Location: " + resultSet.getString("location"));
			}   
			conn.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}  
	}
	
		 
	///////////////////////////////////////////////////////////////
	// Method Name : edit()									     //
	// Return Type : void										 //
	// Parameters : None									 	 //
	// Purpose : Edits the required Venue record in venue        //
	///////////////////////////////////////////////////////////////		
	
	public int edit(int venueID, String venueName, String location)   
	{
		int status = 0;
		String sqlString = "update SportManagement.venue set venueName = "+"\""+ venueName + 
		    		  		"\", location =" + "\"" + location + "\"" + " where venueID = " + venueID;
		
		
		        //+ "\", club = " + "\"" + newClubName + "\"" + " where playerID = " + changeNo;
		
		System.out.println(sqlString);
		status = databaseUpdate(sqlString);                                           
		
		return status;
	}
	

	///////////////////////////////////////////////////////////////////
	// Method Name : delete()									     //
	// Return Type : void										     //
	// Parameters : None									 	     //
	// Purpose : Deletes the required Venue record from venue        //
	///////////////////////////////////////////////////////////////////	
	
	public int delete(int venueNoIn)   
	{
		int status = 0; 
			    
		String sqlString = "delete from SportManagement.venue where venueID = " + venueNoIn;     
		status = databaseUpdate(sqlString);
		
		return status;
	}	

	
	    
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
