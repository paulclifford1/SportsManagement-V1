package MainClasses;
import java.sql.*;
import java.util.ArrayList;


/**
 * Class Writer: Mark Melling
 * Instructor: Paul Corey & Helena Gibson
 * Description: Name Class
 * Date: 127/02/2016
 * @author Mark Melling
 * @version 4.0
**/

@SuppressWarnings("unused")
public class Team
{
	 private String teamName;  //Team name
	 private int noOfPlayers;  //Number of players on the team
	 private int teamID;       //Team ID
	
		
	 //sql and database variables
	 private String url = "jdbc:mysql://localhost:3306/";
	 private String dbName = "SportManagement?useSSL=false";
	 private String driver = "com.mysql.jdbc.Driver";
	 private String userName = "root";
	 private String password = "password";
	 private Statement statement = null;   
	 private ResultSet resultSet = null;
	 
	 //Default constructor
	 public Team()
	 {
	    teamName = null;
	    noOfPlayers = 0; 
	 }
		
	//Initialized Constructor
	 public Team(int teamID, String name, int noOfPlayers)
	 {
		this.teamID = teamID;
	    this.teamName = name;
	    this.noOfPlayers = noOfPlayers;
	 }
	 
	 //GETTERS AND SETTERS
	 public String getTeamName()
	 {
	    return teamName;
	 }
		
	 public void setTeamName(String name)
	 {
	    this.teamName = name;
	 }
		
	 public int getNoOfPlayers()
	 {
	    return noOfPlayers;
	 }
		
	 public void setNoOfPlayers(int noOfPlayers)
	 {
	    this.noOfPlayers = noOfPlayers;
	 }
		
	 public int getTeamID()
	 {
	    return teamID;
	 }
		
		//Returns information about the Team object
	 public String toString()
	 {
	    return "    " + teamID + "\t\t" + teamName + "\t\t" + noOfPlayers + "\n";
	 }
		
	 
	///////////////////////////////////////////////////////
	// Method Name : add()								 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads one Team record from the user     //
	//           and adds it to the ArrayList teams      //
	///////////////////////////////////////////////////////		
	 
	 public int add(Team tIn)   
	 { 
	     
	     //Then do your normal adding a Team stuff
		 int status = 0;
	    
		String sqlString="insert into sportmanagement.fixture(fixtureID,firstTeamID,firstTeamID,refereeID,venueID,day,time) values("+
				tIn.getTeamID() + ",\"" + tIn.getTeamName() + "\"," + tIn.getNoOfPlayers() +")";
	    System.out.println(sqlString);
	    status = databaseUpdate(sqlString);
	    return status;
	 }
	 

	///////////////////////////////////////////////////////
	// Method Name : list()								 //
	// Return Type : void					   		     //
	// Parameters : None								 //
	// Purpose : Lists all Team records in teams         //
	///////////////////////////////////////////////////////	
	 
	 public void getAllTeams()      
	 { 
	    try 
	    {
	       Class.forName("com.mysql.jdbc.Driver");
	       Connection conn = DriverManager.getConnection(url + dbName, userName, password);
	       statement = conn.createStatement();
	       resultSet = statement.executeQuery("select * from SportManagement.Team");
	       
	       while (resultSet.next() )    
	       {
	    	   System.out.println("Team ID: " + resultSet.getInt("teamID") + "\nTeam Name: " + resultSet.getString("teamName")
				+"\nNumber of Players: " + resultSet.getInt("noOfPlayers"));
	       }
	       conn.close();
	    } 
	    catch (Exception e) 
	    {
	       e.printStackTrace();
	    }    
	 } 
	
	 
	 ///////////////////////////////////////////////////////////////
	 // Method Name : view()									  //
	 // Return Type : void										  //
	 // Parameters : None									 	  //
	 // Purpose : Displays the required Player record on screen   //
	 ///////////////////////////////////////////////////////////////
	 
	 public void getTeam(int searchNo)
	 {
		 try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
	    	  Connection conn = DriverManager.getConnection(url + dbName, userName, password);
	    	  statement = conn.createStatement();
	    	  resultSet = statement.executeQuery("select * from SportManagement.team where SportManagement.team.teamID = " + searchNo);
	                 
	    	  while ( resultSet.next() )      
	    	  {
	        	 System.out.println("Team ID: " + resultSet.getInt("teamID") + ", Team Name: " + resultSet.getString("teamName")
                         				+", Number of Players: " + resultSet.getInt("noOfPlayers"));
	    	  }   
	    	  conn.close();
	      } 
	      catch (Exception e) 
	      {
	    	  e.printStackTrace();
	      }  
	 }
	 
	 
	 ///////////////////////////////////////////////////////////////
	 // Method Name : edit()									  //
	 // Return Type : void										  //
	 // Parameters : None									 	  //
	 // Purpose : Edits the required Player record in player      //
	 ///////////////////////////////////////////////////////////////	
	 
	 public int edit(int teamID, String teamName, int noOfPlayers)   
	   {
	      int status = 0;
	      String sqlString = "update SportManagement.Team set teamName = "+"\""+ teamName + 
	    		  			 "\", noOfPlayers =  " + noOfPlayers + " where teamID = " + teamID;
	      System.out.println(sqlString);
	      status = databaseUpdate(sqlString);                                           
	               
	      return status;
	   }

	 
	///////////////////////////////////////////////////////////////////
	// Method Name : delete()									     //
	// Return Type : void										     //
	// Parameters : None									 	     //
	// Purpose : Deletes the required Team record from teams         //
	///////////////////////////////////////////////////////////////////	
	 
	public int delete(int teamNoIn)   
	{
		int status = 0; 
		    
		String sqlString = "delete from SportManagement.team where teamID = " + teamNoIn;     
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
