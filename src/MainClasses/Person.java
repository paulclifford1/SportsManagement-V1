package MainClasses;
import java.util.Scanner;


/** Class Writer: Mark Melling
* Instructor: Paul Corey & Helena Gibson
* Description: Name Class
* Date: 27/02/2016
* @author Mark Melling
* @version 4.0
**/

public abstract class Person
{
	//COMPOSITION - Person HAS-A name
	protected Name name;
	protected String phoneNumber;
	protected String emailAddress;

	// Default Constructor
	public Person()
	{
	   name = new Name();
	   phoneNumber = null;
	   emailAddress = null;
	}

	// Initialisation Constructor
	
	public Person(String fName, String sName, String phoneNumber, String emailAddress)
	{
		name = new Name(fName, sName); // Calls name initialization constructor
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	// toString() method
	// ==> Calls Name's toString() to display name and
	//		then displays phoneNumber
	
	public String toString()
	{
		return name + "\nTel NO: " + phoneNumber + "\nEmail: " + emailAddress;
	}

	
	// set() and get() methods
	public void setName(Name nameIn)
	{
		name = nameIn;
	}
	public Name getName()
	{
		return name;
	}
				
	public void setPhoneNumber(String phoneNumberIn)
	{
		phoneNumber = phoneNumberIn;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setEmailAddress(String emaiAddressIn)
	{
		emailAddress = emaiAddressIn;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	
	////////////////////////////////////////////
	// Method Name : read()				      //
	// Return Type : void	 		          //
	// Parameters : None					  //
	// Purpose : Reads a Person from the user //
	////////////////////////////////////////////
	
   @SuppressWarnings("resource")
	public void read()
   {
		name.read();
	    
		Scanner KeyIn = new Scanner(System.in);		
 
	    System.out.print("Phone Number: ");
	    phoneNumber = KeyIn.nextLine();
	    
	    System.out.print("Email Address: ");
	    emailAddress = KeyIn.nextLine();
	}	
}