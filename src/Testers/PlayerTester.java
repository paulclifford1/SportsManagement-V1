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

public class PlayerTester 
{
   @SuppressWarnings({ "resource"})
   public static void main(String[] args) 
   {
	   int menuOpt = 0;   
      
	   Scanner keyboard = new Scanner(System.in);
	   Scanner keyIn = new Scanner(System.in);
	   Player myPlayer = new Player();
       
	   do  
	   {
		   System.out.print("\n\n\tWelcome to GAA Sports Management System");
		   System.out.println("\n\n\t    ***ENTER PLAYER DETAILS***");
		   System.out.println("\n\n1. Add New Player");
		   System.out.println("2. List All Players");
		   System.out.println("3. View Player");
		   System.out.println("4. Edit Player");
		   System.out.println("5. Delete Player");
		   System.out.println("6. Quit");
         
		   menuOpt = keyIn.nextInt();
         
		   switch(menuOpt)  
		   {
         
		   	case 1://add a new Player
				
			System.out.println("\n\nEnter New Player Details");
				                  
			System.out.println("Enter Player ID:");
			int playerID  = keyIn.nextInt();
				
			System.out.println("Enter First Name:\t");
			String fNname = keyboard.nextLine();
				   
			System.out.println("Enter Surname:\t");
			String nSname  = keyboard.nextLine();
				  
			System.out.println("Enter Number:\t");
			String phoNumber = keyboard.nextLine();
				
			System.out.println("Enter Email:\t");
			String email  = keyboard.nextLine();
				
			System.out.println("DOB Enter Day:\t");
			int dobDay  = keyIn.nextInt();
				
			System.out.println("DOB Enter Month:\t");
			int dobMonth  = keyIn.nextInt();
				
			System.out.println("DOB Enter Year:\t");
			int dobYear  = keyIn.nextInt();
				
			System.out.println("Join Day:\t");
			int sDay  = keyIn.nextInt();
				
			System.out.println("Join Month:\t");
			int sMonth  = keyIn.nextInt();
				
			System.out.println("Join Year:\t");
			int sYear  = keyIn.nextInt();
				
			System.out.println("Enter Team:\t");
			String club  = keyboard.nextLine();
				
			Player newPlayer = new Player(playerID, fNname, nSname, phoNumber, email, dobDay, dobMonth, dobYear, sDay, sMonth, sYear, club);
			int addStatus = myPlayer.add(newPlayer);
				   
			if (addStatus==1)
			{
				System.out.println("Successfully Added to Database");
			}
			break;
         
         
		   	case 2: //Display All PLAYERS
             
	        myPlayer.getAllPlayers();
	            
	        break;
             
               
		   	case 3: //Display Player
         	
	        int searchPlayerNo = 0;
	             
	        System.out.println("\n\nEnter Player ID: ");
	        searchPlayerNo = keyIn.nextInt();
	            
	        myPlayer.getPlayer(searchPlayerNo);
            
	        break;
             
            
		   	case 4:
	         	
	        	 
	        System.out.println("\n\nEnter New Player Details");
	            
	        System.out.print("\n\nEnter Player ID: ");
	        int changeNo = keyIn.nextInt(); 
	            
	        System.out.print("Enter First Name:\t");
	        String newFname = keyboard.nextLine();
	               
	        System.out.print("Enter Surname:\t");
	        String newSname  = keyboard.nextLine();
	              
	        System.out.print("Enter Number:\t");
	        String newNumber = keyboard.nextLine();
	        	
	        System.out.print("Enter Email:\t");
	        String newEmail = keyboard.nextLine();
	        	
	        System.out.print("DOB Enter Day:\t");
	        int newDOBday = keyIn.nextInt();
	        	
	        System.out.print("DOB Enter Month:\t");
	        int newDOBmonth = keyIn.nextInt();
	        	
	        System.out.print("DOB Enter Year:\t");
	        int newDOByear = keyIn.nextInt();
	        	
	        System.out.print("Join Day:\t");
	        int newSday = keyIn.nextInt();
	        	
	        System.out.print("Join Month:\t");
	        int newSmonth = keyIn.nextInt();
	        	
	        System.out.print("Join Year:\t");
	        int newSYear = keyIn.nextInt();
	        	
	        System.out.print("Enter Team:\t");
	        String newTeamName  = keyboard.nextLine(); 
	             
	        int changeStatus = myPlayer.edit(changeNo, newFname, newSname, newNumber, newEmail,  newDOBday, newDOBmonth, newDOByear, newSday, newSmonth, newSYear, newTeamName);          
	             
	        if (changeStatus == 1)
	        {
	        	System.out.println("Record Updated");
	        }
	        break;
       
         
		   	case 5:
		   		
	        int delPlayerNo = 0;
	               
	        System.out.print("\n\nEnter Team ID: ");
	        delPlayerNo = keyIn.nextInt(); 
	               
	        int delStatus = myPlayer.delete(delPlayerNo);
	               
	        if (delStatus == 1)
	        {
	        	System.out.println("Player Record Deleted");
	        }       
	        break;
	            
		   	case 6://Quit
			break;
		 }
      }while (menuOpt != 6);          
   }
}
