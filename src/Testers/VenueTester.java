package Testers;
import MainClasses.*;

import java.util.*;  

/**
 * Class Writer: Mark Melling
 * Instructor: Paul Corey & Helena Gibson
 * Description: Name Class
 * Date: 27/02/2016
 * @author Mark Melling
 * @version 4.0
**/

public class VenueTester 
{
   @SuppressWarnings("resource")
   public static void main(String[] args) 
   {
	   int menuOpt = 0;   
      
	   Scanner keyboard = new Scanner(System.in);
	   Scanner keyIn = new Scanner(System.in);
	   Venue myVenue = new Venue();
       
	   do  
	   {
		   System.out.print("\n\tWelcome to GAA Sports Management System");
		   System.out.println("\n\n\t    ***ENTER VENUE DETAILS***");
		   System.out.println("\n\n1. Add New Venue");
		   System.out.println("2. List All Venues");
		   System.out.println("3. View Venue");
		   System.out.println("4. Edit Venue");
		   System.out.println("5. Delete Venue");
		   System.out.println("6. Quit");
         
		   menuOpt = keyIn.nextInt();
         
		   switch(menuOpt)  
		   {
         
		   
		   	case 1://add a new team

		   	System.out.println("\n\nEnter New Venue Values");
		   	
		   	System.out.print("Enter Venue ID:\t");
        	int newVenueID = keyIn.nextInt();
                              
        	System.out.print("Enter Venue Name:\t");
        	String newVenueName = keyboard.nextLine();
               
        	System.out.print("Enter Venue Location:\t");
        	String newLocation = keyboard.nextLine();
              
        	
        	Venue newVenue = new Venue (newVenueID, newVenueName, newLocation);
        	int addStatus = myVenue.add (newVenue);
               
        	if (addStatus==1)
        	{
        		System.out.println("Record Successfully Added to Database");
        	}
        	break;   
         
         
		   	case 2: //Display All Teams
             
        	System.out.println("Venue Number \t\tTeam Name\t\tNoPlayers");
            
        	myVenue.getAllVenues();
            break;
             
               
		   	case 3: //Display a Specific Team
         	
            System.out.println("\n\nEnter Venue ID: ");
            int searchTeamNo = keyIn.nextInt();
             
            myVenue.getVenue(searchTeamNo);
             
            break; 
             
            
		   	case 4://Edit Team
         	
        	System.out.print("\n\nEnter Venue Number: ");
            int changeNo = keyIn.nextInt(); 
             
            System.out.print("\n\nEnter Venue Name: ");
            String newName = keyboard.nextLine();
             
            System.out.print("\n\nEnter Venue Location: ");
            String changeLocation = keyboard.nextLine();
             
            int changeStatus = myVenue.edit(changeNo, newName, changeLocation);
             
            if (changeStatus == 1)
            {
                System.out.println("Record Updated");
            }
            break;
       
         
		   	case 5://Delete
            int delVenueNo = 0;
               
            System.out.print("\n\nEnter Venue ID: ");
            delVenueNo = keyIn.nextInt(); 
               
            int delStatus = myVenue.delete(delVenueNo);
               
            if (delStatus == 1)
            {
            	System.out.println("Record Deleted");
            }       
            break;
            
		    case 6://Quit
		   	break;
		 }
      }while (menuOpt != 6);          
   }
}