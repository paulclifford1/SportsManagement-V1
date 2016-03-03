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

public class Referee extends Person
{										// INHERITANCE - Referee IS-A Person
										// Referee has name & phoneNumber from Person
										// A startDate & Referee ID number	
	private Date joinDate;
	private int refereeID;						
	private String club;
	//private String pass;
	//private int matchCount;
	
	
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
	// Called when object is created like this ==> Referee eObj = new Referee();	
	public Referee()
   {	
		super();
		joinDate = new Date();
  		club = null;
   }
				   
    // Initialization Constructor
	// Called when object is created like this ==>
	// Referee prObj = new Referee("Mark","Melling","087 1234567", "markmelling@lyit.com", 25,12,1970, 1,1,2010, Donegal);

	public Referee(int refereeID, String fN, String sn, String phoneNo, String email, 
  		          int sD, int sM, int sY, String club)
	{
     // Call super class constructor - Passing parameters required by Person ONLY!
	   super(fN, sn, phoneNo, email);
	   
	   // And then initialize referees own instance variables
	   this.refereeID = refereeID;
	   joinDate = new Date(sD, sM, sY);
	   this.club = club;
	}

  
	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	
	@Override
	public String toString()
	{
		return "\n\nReferee ID: " + refereeID + "\n" + super.toString() + "\nClub: " + club + "\nReferee Sign Date: " + joinDate;
	}

	// ==> Called when comparing an object with another object, e.g. - if(emp1.equals(emp2))										
	// Because Referee number is unique (static) its sufficient to compare the number
	
	public boolean equals(Referee refereeIn)
	{
		if(refereeID == refereeIn.refereeID)
			return true;
		else
			return false;
	}

	
	public void setStartDate(Date startDate)
	{
		this.joinDate=startDate;
	}
	
	public Date getStartDate()
	{
		return joinDate;
	}
	
	public int getRefereeID()
	{
		return refereeID;
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
	
	public int add(Referee rIn)   
	{ 
		int status=0;
		    
		String sqlString = "insert into SportManagement.referee(refereeID, fName, sName, phoneNumber, email, signDate, club) values("+
				rIn.getRefereeID() + ",\"" + rIn.name.getFirstName() + "\"," + "\"" + rIn.name.getSurname() + "\"," + "\"" + rIn.getPhoneNumber()
				+ "\"," + "\"" + rIn.getEmailAddress() + "\"," + "\"" + rIn.joinDate.getDay() + "/" + rIn.joinDate.getMonth() + "/" 
				+ rIn.joinDate.getYear() + "\"," + "\"" + rIn.getClub() + "\"" + ")";
		System.out.println(sqlString);
		status = databaseUpdate(sqlString);
		return status;
	}
			
		
	///////////////////////////////////////////////////////
	// Method Name : list()								 //
	// Return Type : void					   		     //
	// Parameters : None								 //
	// Purpose : Lists all Referee records in referees   //
	///////////////////////////////////////////////////////	
	
	public void getAllReferees()      
	{ 
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(url+dbName,userName,password);
		    statement = conn.createStatement();
		    resultSet = statement.executeQuery("select * from SportManagement.referee");
		    
		    while ( resultSet.next() )    
		    {
		    	System.out.println("\n\nReferee ID: " + resultSet.getInt("refereeID") + "\nReferee Name: " + resultSet.getString("fName") + " " + resultSet.getString("sName") 
		    						+ "\nPhone Number: " + resultSet.getString("phoneNumber") + "\nEmail Address: " + resultSet.getString("email") + "\nDate Joined: " + 
		    						resultSet.getString("signDate") + "\nClub Name: " + resultSet.getString("club"));
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
	// Purpose : Displays the required Referee record on screen  //
	///////////////////////////////////////////////////////////////
	
	public void getReferee(int searchNo)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from SportManagement.referee where SportManagement.referee.refereeID = " + searchNo);
		                 
			while ( resultSet.next() )      
		    {
				
				System.out.println("\n\nReferee ID: " + resultSet.getInt("refereeID") + "\nReferee Name: " + resultSet.getString("fName") + " " + resultSet.getString("sName") 
				+ "\nPhone Number: " + resultSet.getString("phoneNumber") + "\nEmail Address: " + resultSet.getString("email") + "\nDate Joined: " + resultSet.getString("signDate")
				+ "\nClub Name: " + resultSet.getString("club"));
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
	// Purpose : Edits the required Referee record in referee    //
	///////////////////////////////////////////////////////////////
	
	public int edit(int changeNo, String fName,String sName, String newNumber, String newEmail,
				    int newSday, int newSmonth, int newSyear, String newClubName)   
	{
		int status = 0;
		String sqlString = "update SportManagement.referee set fName = " + "\"" + fName + "\", sName = " + "\"" + sName + "\", phoneNumber = " + "\"" + newNumber
							+ "\", email = " + "\"" + newEmail + "\", signDate = " + "\"" + newSday + "/" + newSmonth + "/" + newSyear + "\", club = " + "\"" + newClubName 
							 + "\"" + " where refereeID = " + changeNo;
		
		System.out.println(sqlString);
		status = databaseUpdate(sqlString);                                           
		               
		return status;
	}
		 
	
	///////////////////////////////////////////////////////////////////
	// Method Name : delete()									     //
	// Return Type : void										     //
	// Parameters : None									 	     //
	// Purpose : Deletes the required Referee record from referee    //
	///////////////////////////////////////////////////////////////////	
	
	public int delete(int refereeNoIn)   
	{
		int status = 0; 
			    
		String sqlString = "delete from SportManagement.referee where refereeID = " + refereeNoIn;     
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

