package MainClasses;
import java.util.Scanner;
import java.io.Serializable;


/**
 * Class Writer: Mark Melling
 * Instructor: Paul Corey & Helena Gibson
 * Description: Name Class
 * Date: 27/02/2016
 * @author Mark Melling
 * @version 4.0
**/

public class Date implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int day;
	private int month;
	private int year;

   // Default Constructor 
   // Called when a Date object is created as follows - Date d1 = new Date();
   
   public Date()
   {
	   day = month = year = 0;
   }

    // Initialization Constructor
    // Called when a Date object is created as follows - Date d2 = new Date(14,9,2010);
   
 	public Date(int day, int month, int year)throws IllegalArgumentException
 	{
	   if(day <=0 || day > 31 || month < 0 || month > 12 || year < 0)
		   throw new IllegalArgumentException("***Invalid Date***");		

   	this.day = day;
   	this.month = month;
	this.year = year;
  }

   // toString() method
   // Called when a String of the class is used, e.g. - System.out.print(d1);
   // or System.out.print(d1.toString());
 	
   public String toString()
   {
	  return (day + "/" + month + "/" + year);
   }
	
  
   // get methods
   // Called when retrieving part of an object, e.g. - if (d1.getYear() == d2.getYear())
   
   public int getDay()
   {
	  return day;
   }
   
   public int getMonth()
   {
	   return month;
   }
   
   public int getYear()
   {
	   return year;
   }

	// set methods
	// Called when setting part of an object, e.g. - d1.setDay(14);
	//												 d1.setMonth(9);
	//												 d1.setYear(2010);
   
	public void setDay(int setDayTo) throws IllegalArgumentException
	{
	   if(setDayTo <=0 || setDayTo > 31)
		  throw new IllegalArgumentException("***Day Not Valid***");		

	   //NO EXCEPTION THROWN
  	   day = setDayTo;
	}
	
 	public void setMonth(int setMonthTo)throws IllegalArgumentException
 	{
 	   if(setMonthTo <= 0 || setMonthTo > 12)
 		   throw new IllegalArgumentException("***Month Not Valid***");		

 		//NO EXCEPTION THROWN
 		month = setMonthTo;
 	}
 	
 	public void setYear(int setYearTo)throws IllegalArgumentException
 	{
 	   if(setYearTo <= 0)
 		   throw new IllegalArgumentException("***Year Not Valid***");		

 		// NO EXCEPTION THROWN
 		year = setYearTo;
 	}

	//////////////////////////////////////////
	// Method Name : read()					//
	// Return Type : void		 		    //
	// Parameters : None					//
	// Purpose : Reads a Date from the user //
	//////////////////////////////////////////	
 	
    @SuppressWarnings("resource")
	public void read(int dateType)
    {
 	   Scanner KeyIn = new Scanner(System.in);		
		
		if(dateType == 1 )
		   System.out.println("Date of Birth: ");	
		
		else if(dateType == 2)
		   System.out.println("Signed Player Date: ");
		
		else if(dateType == 3)
			   System.out.println("Joined Club Date: ");
			
	   System.out.print("Day: ");   
	   int dayIn = KeyIn.nextInt();
	   
	   System.out.print("Month: "); 
	   int monthIn = KeyIn.nextInt();
	   
	   System.out.print("Year: ");  
	   int yearIn = KeyIn.nextInt();				
	   
	   boolean goodInput = false;
	   do
	   {		
			try
			{
				setDay(dayIn);
				setMonth(monthIn);
				setYear(yearIn);								
				goodInput = true;
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Invalid Input Please Re-enter Valid Date");
				System.out.println(e);
				System.out.print("Please Enter Valid Day: ");
				{
					dayIn = KeyIn.nextInt();
				}
				
				System.out.print("Please Enter Valid Month: ");
				{
					monthIn = KeyIn.nextInt();
				}
				
				System.out.print("Please Enter Valid Year: ");
				{
					yearIn = KeyIn.nextInt();								
				}
			}
		}while(!goodInput);
	}
}


