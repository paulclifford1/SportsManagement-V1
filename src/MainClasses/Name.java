package MainClasses;
import java.util.Scanner;


/** Class Writer: Mark Melling
* Instructor: Paul Corey & Helena Gibson
* Description: Name Class
* Date: 27/02/2016
* @author Mark Melling
* @version 4.0
**/

public class Name
{
	// Instance Variables
	private String fName;	
	private String sName;		
	
	// Constructors to initialize the Instance Variables
	// Default Constructor 
	// Called when a Name object is created as follows - 
	// Name n1 = new Name();
	
	public Name()
	{
	   fName = sName = null;
	}

	// Initialization Constructor
	// Called when a Name object is created as follows - 
	// Name n2 = new Name("Mark","Melling");
	
	public Name(String fN, String sn)
	{
	   fName = fN;
	   sName = sn;
	}

	// toString() method
	// Called when a String of the class is used, e.g. - 
	// System.out.print(n1);
	// or System.out.print(n1.toString());
	
	public String toString()
	{
	   return "Player Name: " + fName + " " + sName;
	}
	
	
	public String getFirstName()
	{
	   return fName;
	}
	
	public void setFirstName(String setFirstNameTo)
	{
		fName = setFirstNameTo;
	}
	
	public String getSurname()
	{
	   return sName;
	}
	
	public void setSurname(String setSurnameTo)
	{
		sName = setSurnameTo;
	}


	//////////////////////////////////////////
	// Method Name : read()					//
	// Return Type : void		 		    //
	// Parameters : None					//
	// Purpose : Reads a Name from the user //
	//////////////////////////////////////////	
	
   @SuppressWarnings("resource")
	public void read()
   {
	   Scanner KeyIn = new Scanner(System.in);		
	   
      System.out.println("Enter Name ");
      
	   System.out.print("First Name: ");
	   String firstNameIn = KeyIn.nextLine();
	   
	   System.out.print("Surname: ");
	   String surNameIn = KeyIn.nextLine();				
		
	   boolean goodInput = false;

	   do
	   {		
		   try
		   {
			   setFirstName(firstNameIn);
			   setSurname(surNameIn);								
			   goodInput = true;
		   }
		   catch(IllegalArgumentException e)
		   {
			   System.out.println("***Invalid Name Input***");
			   System.out.println(e);
			   
			   System.out.print("RE-ENTER Valid First Name: ");
			   {
				   firstNameIn = KeyIn.nextLine();
			   }
			   
			   System.out.print("RE-ENTER Valid Surname : ");
			   {
				   surNameIn = KeyIn.nextLine();				
			   }
			}
	   }while(!goodInput);
   }	
}