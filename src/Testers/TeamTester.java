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

public class TeamTester 
{
   @SuppressWarnings("resource")
   public static void main(String[] args) 
   {
	   int menuOpt = 0;   
      
	   Scanner keyboard = new Scanner(System.in);
	   Scanner keyIn = new Scanner(System.in);
	   Team myTeam = new Team();
       
	   do  
	   {
		   System.out.print("\n\tWelcome to GAA Sports Management System");
		   System.out.println("\n\n\t    ***ENTER TEAM DETAILS***");
		   System.out.println("\n\n1. Add New Team");
		   System.out.println("2. List All Team");
		   System.out.println("3. View Team");
		   System.out.println("4. Edit Team");
		   System.out.println("5. Delete Team");
		   System.out.println("6. Quit");
         
		   menuOpt = keyIn.nextInt();
         
		   switch(menuOpt)  
		   {
         
		   	case 1://add a new team

		   	System.out.println("\n\nEnter New Team Values");
		   	
		   	System.out.print("Enter Team ID:\t");
        	int nTeamID = keyIn.nextInt();
                              
        	System.out.print("Enter Team Name:\t");
        	String nTeamName = keyboard.nextLine();
               
        	System.out.print("Enter Number players of Players:\t");
        	int nNoOfPlayers = keyIn.nextInt();
              
        	Team newTeam = new Team(nTeamID, nTeamName, nNoOfPlayers);
        	int addStatus = myTeam.add(newTeam);
               
        	if (addStatus==1)
        	{
        		System.out.println("Record Successfully Added to Database");
        	}
        	break;   
         
         
		   	case 2: //Display All Teams
             
        	System.out.println("Team Number \t\tTeam Name\t\tNoPlayers");
            
            myTeam.getAllTeams();
            break;
             
               
		   	case 3: //Display a Specific Team
         	
            System.out.println("\n\nEnter Team ID: ");
            int searchTeamNo = keyIn.nextInt();
             
            myTeam.getTeam(searchTeamNo);
             
            break; 
             
            
		   	case 4://Edit Team
         	
        	System.out.print("\n\nEnter Team Number: ");
            int changeNo = keyIn.nextInt(); 
             
            System.out.print("\n\nEnter Team Name: ");
            String newName = keyboard.nextLine();
             
            System.out.print("\n\nEnter Number of Players: ");
            int changeNoOfPlayers = keyIn.nextInt(); 
             
            int changeStatus = myTeam.edit(changeNo, newName, changeNoOfPlayers);
             
            if (changeStatus == 1)
            {
                System.out.println("Record Updated");
            }
            break;
       
         
		   	case 5://Delete
            int delTeamNo = 0;
               
            System.out.print("\n\nEnter Team ID: ");
            delTeamNo = keyIn.nextInt(); 
               
            int delStatus = myTeam.delete(delTeamNo);
               
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