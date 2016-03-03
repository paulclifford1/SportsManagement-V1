package Testers;
import MainClasses.*;
import java.util.*;  

/**
 * Class Writer: Mark Melling
 * Instructor: Paul Corey & Helena Gibson
 * Description: Fixture Tester Class
 * Date: 27/02/2016
 * @author Mark Melling
 * @version 4.0
**/

public class FixtureTester 
{
   @SuppressWarnings({ "resource"})
   public static void main(String[] args) 
   {
	   int menuOpt = 0;   
      
	   //Scanner keyboard = new Scanner(System.in);
	   Scanner keyIn = new Scanner(System.in);
	   Fixture myFixture = new Fixture();
       
	   do  
	   {
		   System.out.print("\n\n\tWelcome to GAA Sports Management System");
		   System.out.println("\n\n\t    ***ENTER FIXTURE DETAILS***");
		   System.out.println("\n\n1. Add New Fixture");
		   System.out.println("2. List All Fixtures");
		   System.out.println("3. View Fixture");
		   System.out.println("4. Edit Fixture");
		   System.out.println("5. Delete Fixture");
		   System.out.println("6. Quit");
         
		   menuOpt = keyIn.nextInt();
         
		   switch(menuOpt)  
		   {
         
		   	case 1://add a new Fixture
				
			System.out.println("\n\nEnter New Fixture Details");
				                  
			System.out.println("Enter Fixture ID:");
			int fixtureID  = keyIn.nextInt();
				
			System.out.println("Fixture Date: Enter Day:\t");
			int day  = keyIn.nextInt();
				
			System.out.println("Fixture Date: Enter Month:\t");
			int month  = keyIn.nextInt();
				
			System.out.println("Fixture Date: Enter Year:\t");
			int year  = keyIn.nextInt();
				
			System.out.println("Enter Venue ID:\t");
			int venueID  = keyIn.nextInt();
			
			System.out.println("Enter First Team ID:\t");
			int firstTeamID  = keyIn.nextInt();
			
			System.out.println("Enter Second Team ID:\t");
			int secondTeamID  = keyIn.nextInt();
			
			System.out.println("Enter Referee ID:\t");
			int refereeID  = keyIn.nextInt();
				
			Fixture newFixture = new Fixture(fixtureID, day, month, year, venueID, firstTeamID, secondTeamID, refereeID);
			int addStatus = myFixture.add(newFixture);
				   
			if (addStatus==1)
			{
				System.out.println("Successfully Added to Database");
			}
			break;
         
         
		   	case 2: //Display All Fixtures
             
	        myFixture.getAllFixtures();
	            
	        break;
             
               
		   	case 3: //Display Fixture
         	
	        int searchFixtureNo = 0;
	             
	        System.out.println("\n\nEnter Fixture ID: ");
	        searchFixtureNo = keyIn.nextInt();
	            
	        myFixture.getFixture(searchFixtureNo);
            
	        break;
             
            
		   	case 4:	//Edit Fixture
	         	
	        	 
	        System.out.println("\n\nEnter New Fixture Details");
	            
	        System.out.print("\n\nEnter Fixture ID: ");
	        int changeNo = keyIn.nextInt(); 
	            
	        System.out.println("Fixture Date: Enter Day:\t");
			int newDay  = keyIn.nextInt();
				
			System.out.println("Fixture Date: Enter Month:\t");
			int newMonth  = keyIn.nextInt();
				
			System.out.println("Fixture Date: Enter Year:\t");
			int newYear  = keyIn.nextInt();
				
			System.out.println("Enter Venue ID:\t");
			int newVenueID  = keyIn.nextInt();
			
			System.out.println("Enter First Team ID:\t");
			int newFirstTeamID  = keyIn.nextInt();
			
			System.out.println("Enter Second Team ID:\t");
			int newSecondTeamID  = keyIn.nextInt();
			
			System.out.println("Enter Referee ID:\t");
			int newRefereeID  = keyIn.nextInt(); 
	             
	        int changeStatus = myFixture.edit(changeNo, newDay, newMonth, newYear, newVenueID,  newFirstTeamID, newSecondTeamID, newRefereeID);          
	             
	        if (changeStatus == 1)
	        {
	        	System.out.println("Record Updated");
	        }
	        break;
       
         
		   	case 5:
		   		
	        int delFixtureNo = 0;
	               
	        System.out.print("\n\nEnter Fixture ID: ");
	        delFixtureNo = keyIn.nextInt(); 
	               
	        int delStatus = myFixture.delete(delFixtureNo);
	               
	        if (delStatus == 1)
	        {
	        	System.out.println("Fixture Record Deleted");
	        }       
	        break;
	            
		   	case 6://Quit
			break;
		 }
      }while (menuOpt != 6);          
   }
}