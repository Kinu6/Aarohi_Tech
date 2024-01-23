package aarohi.GenericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * This class id for Java Utility
 * @author kravi
 *
 */
public class JavaUtility {
	/**
	 * This function will give date
	 * @return
	 */
	public String getSystemDate() {
		Date d= new Date();
		return d.toString();
	}
	
	/**
	 * This function will set date in format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d= new Date();
	    String date[]=d.toString().split("");
		 
	    String month=date[1];
	    String date1=date[2];
	    String time=date[3].replace(":", "-");
	    String year= date[4];
	    
	    String finalDate=date1+" "+month+""+year+""+time;
	    return finalDate;	
	}
	
	/**
	 * This function will get random number
	 * @return
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt();
	}
	
	
}
