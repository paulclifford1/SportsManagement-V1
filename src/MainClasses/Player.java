package MainClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/** Class Writer: Mark Melling
* Instructor: Paul Corey & Helena Gibson
* Description: Name Class
* Date: 27/02/2016
* @author Mark Melling
* @version 4.0
**/

public class Player extends Person
{										// INHERITANCE - Player IS-A Person
										// Player has name & phoneNumber from Person
	private Date dob;					// A DOB, startDate & Player ID number	
	private Date joinDate;
	private int playerID;						
	private String club;
	
	//sql and database variables
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbName = "SportManagement?useSSL=false";
	@SuppressWarnings("unused")
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "root";
	private String password = "password";
	private Statement statement = null;   
	private ResultSet resultSet = null;
		
	// Default Constructor
	// Called when object is created like this ==> Player eObj = new Player();	
	public Player()
   {	
		super();
		dob = new Date();
		joinDate = new Date();
  		club = null;
   }
				   
   // Initialization Constructor
	// Called when object is created like this ==>
	// Player prObj = new Player("Mark","Melling","087 1234567", "markmelling@lyit.com", 25,12,1970, 1,1,2010, Donegal);

	public Player(int playerID, String fN, String sn, String phoneNo, String email, int d, int m, int y, 
  		          int sD, int sM, int sY, String club)
	{
     // Call super class constructor - Passing parameters required by Person ONLY!
	   super(fN, sn, phoneNo, email);
	   
	   // And then initialize players own instance variables
	   this.playerID = playerID;
	   dob = new Date(d, m, y);
	   joinDate = new Date(sD, sM, sY);
	   this.club = club;
	}

  
	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	
	@Override
  public String toString()
  {
		return "\n\nPlayer ID: " + playerID + "\n" + super.toString() + "\nDOB: " +
				dob + "\nClub: " + club + "\nPlayer Sign Date: " + joinDate;
  }

	// ==> Called when comparing an object with another object, e.g. - if(emp1.equals(emp2))										
	// Because Employee number is unique (static) its sufficient to compare the number
	
	public boolean equals(Player playerIn)
	{
		if(playerID == playerIn.playerID)
			return true;
		else
			return false;
	}

	//set() and get() methods
	public void setDOB(Date dob)
	{
		this.dob = dob;
	}
	
	public Date getDOB()
	{
		return dob;
	}
	
	public void setStartDate(Date startDate)
	{
		this.joinDate=startDate;
	}
	
	public Date getStartDate()
	{
		return joinDate;
	}
	
	public int getPlayerID()
	{
		return playerID;
	}	
	
	public String getClub()
	{
		return club;
	}

	public void setClub(String club)
	{
		this.club = club;
	}
	
	
	///////////////////////////////////////////////////////
	// Method Name : add()								 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads one Team record from the user     //
	//           and adds it to the ArrayList teams      //
	///////////////////////////////////////////////////////		
	
	public int add(Player pIn)   
	{ 
		int status=0;
		    
		String sqlString = "insert into SportManagement.player(playerID, fName, sName, phoneNumber, email, DOB, signDate, club) values("+
				pIn.getPlayerID() + ",\"" + pIn.name.getFirstName() + "\"," + "\"" + pIn.name.getSurname() + "\"," + "\"" + pIn.getPhoneNumber()
				+ "\"," + "\"" + pIn.getEmailAddress() + "\"," + "\"" + pIn.dob.getDay() + "/" + pIn.dob.getMonth() + "/" + pIn.dob.getYear() + "\","
				+ "\"" + pIn.joinDate.getDay() + "/" + pIn.joinDate.getMonth() + "/" + pIn.joinDate.getYear() + "\"," + "\"" + pIn.getClub() + "\"" + ")";
		System.out.println(sqlString);
		status = databaseUpdate(sqlString);
		return status;
	}
		
		
	
		
		
	///////////////////////////////////////////////////////
	// Method Name : list()								 //
	// Return Type : void					   		     //
	// Parameters : None								 //
	// Purpose : Lists all Player records in players     //
	///////////////////////////////////////////////////////	
	
	public void getAllPlayers()      
	{ 
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(url+dbName,userName,password);
		    statement = conn.createStatement();
		    resultSet = statement.executeQuery("select * from SportManagement.player ORDER BY club ASC");
		    
		    while ( resultSet.next() )    
		    {
		    	System.out.println("\n\nPlayer ID: " + resultSet.getInt("playerID") + "\nPlayer Name: " + resultSet.getString("fName") + " "
		    						+ resultSet.getString("sName") + "\nPhone Number: " + resultSet.getString("phoneNumber") + "\nEmail Address: " 
		    						+ resultSet.getString("email") + "\nDate Of Birth: " + resultSet.getString("DOB") + "\nDate Joined: " 
		    						+ resultSet.getString("signDate") + "\nClub Name: " + resultSet.getString("club"));
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
	// Return Type : void										 //
	// Parameters : None									 	 //
	// Purpose : Displays the required Player record on screen   //
	///////////////////////////////////////////////////////////////
	
	public void getPlayer(int searchNo)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from SportManagement.player ORDER BY id DESC where SportManagement.player.playerID = " + searchNo);
		                 
			while ( resultSet.next() )      
		    {
				
				System.out.println("\n\nPlayer ID: " + resultSet.getInt("playerID") + "\nPlayer Name: " + resultSet.getString("fName") + " "
									+ resultSet.getString("sName") + "\nPhone Number: " + resultSet.getString("phoneNumber")
									+ "\nEmail Address: " + resultSet.getString("email") + "\nDate Of Birth: " + resultSet.getString("DOB")
									+ "\nDate Joined: " + resultSet.getString("signDate") + "\nClub Name: " + resultSet.getString("club"));
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
	// Purpose : Edits the required Player record in player      //
	///////////////////////////////////////////////////////////////
	
	public int edit(int changeNo, String fName,String sName, String newNumber, String newEmail, int  newDOBday, 
					int newDOBmonth, int newDOByear, int newSday, int newSmonth, int newSyear, String newClubName)   
	{
		int status = 0;
		String sqlString = "update SportManagement.player set fName = " + "\"" + fName + "\", sName = " + "\"" + sName + "\", phoneNumber = "
							+ "\"" + newNumber + "\", email = " + "\"" + newEmail + "\", DOB = " + "\"" + newDOBday + "/" + newDOBmonth + "/"
							+ newDOByear + "\", signDate = " + "\"" + newSday + "/" + newSmonth + "/" + newSyear + "\", club = " + "\""
							+ newClubName + "\"" + " where playerID = " + changeNo;
		
		System.out.println(sqlString);
		status = databaseUpdate(sqlString);                                           
		               
		return status;
	}
		 
	
	///////////////////////////////////////////////////////////////////
	// Method Name : delete()									     //
	// Return Type : void										     //
	// Parameters : None									 	     //
	// Purpose : Deletes the required Player record from player      //
	///////////////////////////////////////////////////////////////////	
	
	public int delete(int playerNoIn)   
	{
		int status = 0; 
			    
		String sqlString = "delete from SportManagement.player where playerID = " + playerNoIn;     
		status = databaseUpdate(sqlString);                                        
		return status;
	}
	
		 
	private int databaseUpdate(String sqlUpdate)
	{
		int status = 0;
		 
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

