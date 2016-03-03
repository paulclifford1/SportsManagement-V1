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

public class RefereeTester 
{
   @SuppressWarnings({ "resource"})
   public static void main(String[] args) 
   {
	   int menuOpt = 0;   
      
	   Scanner keyboard = new Scanner(System.in);
	   Scanner keyIn = new Scanner(System.in);
	   Referee myReferee = new Referee();
       
	   do  
	   {
		   System.out.print("\n\n\tWelcome to GAA Sports Management System");
		   System.out.println("\n\n\t    ***ENTER REFEREE DETAILS***");
		   System.out.println("\n\n1. Add New Referee");
		   System.out.println("2. List All Referee");
		   System.out.println("3. View Referee");
		   System.out.println("4. Edit Referee");
		   System.out.println("5. Delete Referee");
		   System.out.println("6. Quit");
         
		   menuOpt = keyIn.nextInt();
         
		   switch(menuOpt)  
		   {
         
		   case 1://add a new Referee
				
		    System.out.println("\n\nEnter New Referee Details");
				                  
			System.out.println("Enter Referee ID:");
			int refereeID  = keyIn.nextInt();
				
			System.out.println("Enter First Name:\t");
			String fNname = keyboard.nextLine();
				   
			System.out.println("Enter Surname:\t");
			String nSname  = keyboard.nextLine();
				  
			System.out.println("Enter Number:\t");
			String phoNumber = keyboard.nextLine();
				
			System.out.println("Enter Email:\t");
			String email  = keyboard.nextLine();
				
			System.out.println("Join Day:\t");
			int sDay  = keyIn.nextInt();
				
			System.out.println("Join Month:\t");
			int sMonth  = keyIn.nextInt();
				
			System.out.println("Join Year:\t");
			int sYear  = keyIn.nextInt();
				
			System.out.println("Enter Team:\t");
			String club  = keyboard.nextLine();
				
			Referee newReferee = new Referee(refereeID, fNname, nSname, phoNumber, email, sDay, sMonth, sYear, club);
			int addStatus = myReferee.add(newReferee);
				   
			if (addStatus==1)
			{
				System.out.println("Successfully Added to Database");
			}
			break;
         
         
		   	case 2: //Display All Referees
             
		   	myReferee.getAllReferees();
	            
		   	break;
             
               
		   	case 3: //Display Referee
         	
	        int searchRefereeNo = 0;
	             
	        System.out.println("\n\nEnter Referee ID: ");
	        searchRefereeNo = keyIn.nextInt();
	            
	        myReferee.getReferee(searchRefereeNo);
            
	        break;
             
            
		   	case 4:
	         	
	         
	        System.out.println("\n\nEnter New Referee Details");
	            
	        System.out.print("\n\nEnter Referee ID: ");
	        int changeNo = keyIn.nextInt(); 
	            
	        System.out.print("Enter First Name:\t");
	        String newFname = keyboard.nextLine();
	               
	        System.out.print("Enter Surname:\t");
	        String newSname  = keyboard.nextLine();
	              
	        System.out.print("Enter Number:\t");
	        String newNumber = keyboard.nextLine();
	        	
	        System.out.print("Enter Email:\t");
	        String newEmail = keyboard.nextLine();
	        	
	        System.out.print("Join Day:\t");
	        int newSday = keyIn.nextInt();
	        	
	        System.out.print("Join Month:\t");
	        int newSmonth = keyIn.nextInt();
	        	
	        System.out.print("Join Year:\t");
	        int newSYear = keyIn.nextInt();
	        	
	        System.out.print("Enter Team:\t");
	        String newTeamName  = keyboard.nextLine(); 
	             
	        int changeStatus = myReferee.edit(changeNo, newFname, newSname, newNumber, newEmail,  newSday, newSmonth, newSYear, newTeamName);          
	             
	        if (changeStatus == 1)
	        {
	        	System.out.println("Record Updated");
	        }
	        break;
       
         
		   	case 5:
		   		
	        int delRefereeNo = 0;
	               
	        System.out.print("\n\nEnter Team ID: ");
	        delRefereeNo = keyIn.nextInt(); 
	               
	        int delStatus = myReferee.delete(delRefereeNo);
	               
	        if (delStatus == 1)
	        {
	        	System.out.println("Referee Record Deleted");
	        }       
	        break; 
	       
		   	case 6://Quit
		   	break;
		 }
      }while (menuOpt != 6);          
   }
}
